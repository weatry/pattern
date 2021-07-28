package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

/**
 * 导出数据的处理类
 */
public abstract class ExportProcessor {
	protected ExportProcessor successor;

	public ExportProcessor getSuccessor() {
		return successor;
	}

	public void setSuccessor(ExportProcessor successor) {
		this.successor = successor;
	}

	public static ExportProcessor buildProcessorChain(ExportProcessor... exportProcessors) {
		if(exportProcessors==null || exportProcessors.length<=0) {
			return null;
		}
		
		ExportProcessor root = exportProcessors[0];
		ExportProcessor pre = root;
		for(int i=1; i<exportProcessors.length; i++) {
			pre.setSuccessor(exportProcessors[i]);
			pre = exportProcessors[i];
		}
		
		return root;
	}
	
	public boolean process(FerryRequest request) throws Exception {
		boolean result = doProcess(request);
		if(result&&successor!=null) {
			result = successor.process(request);
		}
		
		return result;
	}

	protected abstract boolean doProcess(FerryRequest request) throws Exception;
	
}
