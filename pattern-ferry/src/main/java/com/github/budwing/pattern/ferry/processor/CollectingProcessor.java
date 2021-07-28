package com.github.budwing.pattern.ferry.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.budwing.pattern.ferry.service.DataCollector;
import com.github.budwing.pattern.ferry.vo.FerryEntry;
import com.github.budwing.pattern.ferry.vo.FerryRequest;
import com.github.budwing.pattern.ferry.vo.FerryStatus;
import org.apache.log4j.Logger;

/**
 * 数据收集方法。
 * 该方法定义了一个总体的脚本文件，默认脚本文件名称为"<请求id>.ferry"。
 * 该脚本文件中定义了一共有多少个条目要摆渡，以及这些条目的基本信息。
 * 如，对应的摆渡文件、类型等。格式如下：
 * 条目类型：<条目类型属性值>,<条目类型属性值>...,<数据文件名称>
 * 数据会收集到cachePath中
 */
public class CollectingProcessor extends ExportProcessor {
	private static final Logger logger = Logger.getLogger(CollectingProcessor.class);
	protected String suffix = ".ferry";
	private Map<String, DataCollector> dataCollectors;
	
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public Map<String, DataCollector> getDataCollectors() {
		return dataCollectors;
	}

	public void setDataCollectors(Map<String, DataCollector> dataCollectors) {
		this.dataCollectors = dataCollectors;
	}

	public boolean doProcess(FerryRequest request) throws Exception  {
		if (logger.isDebugEnabled()) {
			logger.debug("正在收集摆渡请求"+request.getRequestId()+"的数据！"); 
		}
		boolean result =false;
		
		//因为可能有多个条目需要执行，因此会有时间差，以这个时间点做为当前时间进行统一
		request.setRequestExecuteTime(new Date());
		request.setStatus(new FerryStatus(FerryStatus.GATHER));
		
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
						script = dataCollector.collectEntry(request, entry);
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
			request.setStatus(new FerryStatus(FerryStatus.ERROR));
			logger.error("收集数据出错："+e);
			throw e;
		}
		
		request.setStatus(new FerryStatus(FerryStatus.GATHER_COMPLETE));
		
		if (logger.isDebugEnabled()) {
			logger.debug("请求"+request.getRequestId()+"数据收集完毕！"); 
		}
		
		if (!result) {
			//result为false时证明没有收集到任何数据
			request.setStatus(new FerryStatus(FerryStatus.GATHER_NOTHING));
		}
		
		return true;
	}
	
	public String getExportCachePath() {
		return "d:/";
	}
	
}
