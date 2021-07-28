package com.github.budwing.pattern.weather;

import java.util.List;

public class Ship {
	private List<Equipment> equipments;

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public boolean canSailToday(Weather weather) {
		for(Equipment e:equipments) {
			if(e.isAbnormal()) {
				return false;
			}
		}
		
		if (weather.getMaxWindPower() > 6
				|| "storm".equals(weather.getTyping())
				|| weather.getTemperature() < -10) {
			return false;
		}

		return true;
	}
}
