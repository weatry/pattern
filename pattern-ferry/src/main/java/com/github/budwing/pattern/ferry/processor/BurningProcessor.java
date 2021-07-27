package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.vo.FerryRequest;
import org.apache.log4j.Logger;

public class BurningProcessor extends ExportProcessor {
	private static final Logger logger = Logger.getLogger(BurningProcessor.class);
	
	public boolean doProcess(FerryRequest request) {
		boolean result = false;
		if (logger.isDebugEnabled()) {
			logger.debug("正在刻录"+request.getRequestId()+"的数据！"); 
		}
		
		try {
			result = burning(request);
		} catch (Exception e) {
			logger.error(e);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("刻录"+request.getRequestId()+"的数据结束！"); 
		}
		return result;
	}

	public native boolean burning(FerryRequest request) throws Exception;
	
}
