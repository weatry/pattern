package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.service.DataCollector;
import com.github.budwing.pattern.ferry.service.DataEncryptor;
import com.github.budwing.pattern.ferry.service.PartitionWorker;
import com.github.budwing.pattern.ferry.vo.FerryEntry;
import com.github.budwing.pattern.ferry.vo.FerryRequest;
import com.github.budwing.pattern.ferry.vo.FerryStatus;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DefaultExportProcessor extends ExportProcessor {
	private static final Logger logger = Logger.getLogger(DefaultExportProcessor.class);
	private Map<String, DataCollector> dataCollectors;
	private PartitionWorker partitionWorker;
	private DataEncryptor dataEncryptor;
	
	public Map<String, DataCollector> getDataCollectors() {
		return dataCollectors;
	}

	public void setDataCollectors(Map<String, DataCollector> dataCollectors) {
		this.dataCollectors = dataCollectors;
	}

	public PartitionWorker getPartitionWorker() {
		return partitionWorker;
	}

	public void setPartitionWorker(PartitionWorker partitionWorker) {
		this.partitionWorker = partitionWorker;
	}

	public DataEncryptor getDataEncryptor() {
		return dataEncryptor;
	}

	public void setDataEncryptor(DataEncryptor dataEncryptor) {
		this.dataEncryptor = dataEncryptor;
	}

	/**
	 * 数据收集方法。
	 * 该方法定义了一个总体的脚本文件，默认脚本文件名称为"<请求id>.ferry"。
	 * 该脚本文件中定义了一共有多少个条目要摆渡，以及这些条目的基本信息。
	 * 如，对应的摆渡文件、类型等。格式如下：
	 * 条目类型：<条目类型属性值>,<条目类型属性值>...,<数据文件名称>
	 * 数据会收集到cachePath中
	 */
	public boolean collect(FerryRequest request) throws Exception  {
		if (logger.isDebugEnabled()) {
			logger.debug("正在收集摆渡请求"+request.getRequestId()+"的数据！"); 
		}
		boolean result =false;
		
		//因为可能有多个条目需要执行，因此会有时间差，以这个时间点做为当前时间进行统一
		Date execTime = new Date();
		ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.GATHER);
		
		//脚本文件名称
		String fileName = request.getRequestId()+suffix;
		File ferryFile = new File(getExportCachePath() + fileName);
		
		try {
			ferryFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(ferryFile, false));
			
			List<FerryEntry> entrys = request.getEntrys();
			
			DataCollector dataCollector = null;
			String script = null;
			if (entrys!=null) {
				for (FerryEntry entry : entrys) {
					//依据文件、数据库选择不同的数据收集器
					dataCollector = dataCollectors.get(entry.getEntryObjType());
					if (dataCollector != null) {
						script = dataCollector.collectEntry(request, entry,
								execTime);
						if (script != null && script.length() > 0) {
							writer.write(script);
							writer.newLine();
							result = true;
						} else {
							continue;
						}

						dataCollector = null;
					}
				}
			}
			writer.close();
		} catch (Exception e) {
			ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.ERROR);
			logger.error("收集数据出错："+e);
			throw e;
		}
		
		ferryRequestService.saveExecTime(request.getRequestId(), execTime);
		ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.GATHER_COMPLETE);
		
		if (logger.isDebugEnabled()) {
			logger.debug("请求"+request.getRequestId()+"数据收集完毕！"); 
		}
		
		if (!result) {
			//result为false时证明没有收集到任何数据
			ferryRequestService.changeRequestStatus(request.getRequestId(),
					FerryStatus.GATHER_NOTHING);
		}
		return result;
	}
	
	/**
	 * 按指定大小分块数据，并将分好块的数据转移到burningPath中
	 */
	public boolean partition(final FerryRequest request) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("正在分块请求"+request.getRequestId()+"！"); 
		}
		
		boolean result = false;
		
		ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.PARTITION);
		try {
			result = partitionWorker.doPartition(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.ERROR);
			logger.error("分块出错："+e);
			throw e;
		}
		ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.PARTITION_COMPLETE);
		if(!result) {
			ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.CACHE_FOR_BURNING);
		} else {
			ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.WAIT_BURNING);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("请求"+request.getRequestId()+"分块完成！"); 
		}
		
		return result;
	}

	public boolean encrypt(FerryRequest request) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("正在验证请求"+request.getRequestId()+"的数据！"); 
		}
		List<File> ferryDataFiles = request.getBurningFiles();
		ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.SCAN_VIRUS);
		try {
			if(dataEncryptor.scanVirus(ferryDataFiles)) {
				if(dataEncryptor.scanTrojan(ferryDataFiles)) {
					ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.ENCRYPTING);
					return dataEncryptor.encrypt(ferryDataFiles);
				} else {
					ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.ENCRYPT_FAIL);
				}
			} else {
				ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.SCAN_VIRUS_FAIL);
			}
		} catch (Exception e) {
			ferryRequestService.changeRequestStatus(request.getRequestId(), FerryStatus.ERROR);
			logger.error("数据校验时出错："+e);
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("验证"+request.getRequestId()+"的数据出现问题，可能存在病毒！"); 
		}
		
		return false;
	}

	public native void burning(FerryRequest request) throws Exception;
	
	public String getExportCachePath() {
		return "d:/";
	}
}
