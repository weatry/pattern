package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.service.PartitionWorker;
import com.github.budwing.pattern.ferry.vo.FerryRequest;
import com.github.budwing.pattern.ferry.vo.FerryStatus;
import org.apache.log4j.Logger;

/**
 * 按指定大小分块数据，并将分好块的数据转移到burningPath中
 */
public class PartitionProcessor extends ExportProcessor {
	private static final Logger logger = Logger.getLogger(PartitionProcessor.class);
	protected Long partitionSize = 734003200l; //默认700M
	private PartitionWorker partitionWorker;
	
	public Long getPartitionSize() {
		return partitionSize;
	}

	public void setPartitionSize(Long partitionSize) {
		this.partitionSize = partitionSize;
	}

	public PartitionWorker getPartitionWorker() {
		return partitionWorker;
	}

	public void setPartitionWorker(PartitionWorker partitionWorker) {
		this.partitionWorker = partitionWorker;
	}
	
	public boolean doProcess(final FerryRequest request) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("正在分块请求"+request.getRequestId()+"！"); 
		}
		
		boolean result = false;
		request.setStatus(new FerryStatus(FerryStatus.PARTITION));
		try {
			result = partitionWorker.doPartition(request);
		} catch (Exception e) {
			request.setStatus(new FerryStatus(FerryStatus.ERROR));
			logger.error("分块出错："+e);
			throw e;
		}
		request.setStatus(new FerryStatus(FerryStatus.PARTITION_COMPLETE));
		if(!result) {
			request.setStatus(new FerryStatus(FerryStatus.CACHE_FOR_BURNING));
		} else {
			request.setStatus(new FerryStatus(FerryStatus.WAIT_BURNING));
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("请求"+request.getRequestId()+"分块完成！"); 
		}
		
		return true;
	}

}
