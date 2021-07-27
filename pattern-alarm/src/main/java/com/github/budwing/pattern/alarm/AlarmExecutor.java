package com.github.budwing.pattern.alarm;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class AlarmExecutor {
	private PriorityBlockingQueue<Alarm> queue = new PriorityBlockingQueue<Alarm>();
	private ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
	
	public void execute(Alarm alarm) {
		queue.offer(alarm);
	}

	public void start() {
		while(true) {
			Alarm alarm = queue.poll();
			Future<Boolean> result = threadPool.submit(alarm);
			try {
				if(!result.get() && alarm.getRetryTimes()>0) {
					alarm.decreaseRetryTimes();
					queue.offer(alarm);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*public static void main(String[] args) {
		Alarm a = new Alarm();
		a.setDesease("伤寒");
		a.setDistrict("山东省潍坊市");
		a.setDuration(5);
		a.setPatientNumber(38);
		a.setTime(new Date());

		a.setSmsURL("http://www.sina.com.cn");

		a.sendMsg(new ArrayList());
	}*/
}

