package com.github.budwing.pattern.facade;

import java.util.ArrayList;
import java.util.List;

public class ControlPanel {
	private List<Camera> cameras;
	private List<Light> lights;
	private List<Sensor> sensors;
	private Alarm alarm;

	public ControlPanel() {
		this.cameras = new ArrayList(10);
		for (int i = 0; i < 10; i++) {
			this.cameras.add(new Camera());
		}
		this.lights = new ArrayList(20);
		for (int i = 0; i < 20; i++) {
			this.lights.add(new Light());
		}
		this.sensors = new ArrayList(5);
		for (int i = 0; i < 5; i++) {
			this.sensors.add(new Sensor());
		}
		alarm = new Alarm();
	}
	
	public void startMonitor() {
		openAllCamera();
		openAllLight();
		openAllSensor();
	}
	
	public void openAllCamera() {
		for(int i=0; i<cameras.size();i++) {
			cameras.get(i).open();
		}
	}

	public void openAllLight() {
		for(int i=0; i<lights.size();i++) {
			lights.get(i).turnon();
		}
	}

	public void openAllSensor() {
		
		for (int i = 0; i < sensors.size(); i++) {
			this.sensors.get(i).start();
		}
	}

	public void openCamera(int index) {
		this.cameras.get(index).open();
	}

	public void openLight(int index) {
		this.lights.get(index).turnon();
	}

	public void openSensor(int index) {
		this.sensors.get(index).start();
	}

	public void openAlarm() {
		this.alarm.entry();
	}

	public void closeCamera(int index) {
		this.cameras.get(index).close();
	}

	public void closeLight(int index) {
		this.lights.get(index).turnoff();
	}

	public void closeSensor(int index) {
		this.sensors.get(index).stop();
	}

	public void closeAlarm() {
		this.alarm.exit();
	}
}
