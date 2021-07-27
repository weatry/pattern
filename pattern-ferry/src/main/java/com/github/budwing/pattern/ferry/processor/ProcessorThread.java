package com.github.budwing.pattern.ferry.processor;

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
				processor.process(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
