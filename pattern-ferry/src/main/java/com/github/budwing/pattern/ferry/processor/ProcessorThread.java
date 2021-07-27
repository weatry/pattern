package com.training.refactor.ferry.processor;

import com.github.budwing.pattern.ferry.processor.ExportProcessor;
import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.util.concurrent.BlockingQueue;

public class ProcessorThread extends Thread {
	protected BlockingQueue<FerryRequest> queue;
	protected ExportProcessor processor;
	protected volatile boolean stop = false;
	
	public ProcessorThread(BlockingQueue<FerryRequest> queue,
			ExportProcessor processor) {
		super();
		this.queue = queue;
		this.processor = processor;
	}
	
	public void stopRun() {
		stop = true;
	}

	public void run() {
		while (!stop) {
			try {
				FerryRequest request = queue.take();
				if (processor.collect(request)) {
					if (processor.encrypt(request)) {
						if(processor.partition(request)) {
							processor.burning(request);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
