package com.github.budwing.pattern.weather;

public class Weather {
	private String typing;
	private Double temperature;
	private Integer maxWindPower;
	private String windDirection;

	public Weather() {
		super();
	}

	public Weather(String typing, Double temperature, Integer maxWindPower,
			String windDirection) {
		super();
		this.typing = typing;
		this.temperature = temperature;
		this.maxWindPower = maxWindPower;
		this.windDirection = windDirection;
	}

	public String getTyping() {
		return typing;
	}

	public void setTyping(String typing) {
		this.typing = typing;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getMaxWindPower() {
		return maxWindPower;
	}

	public void setMaxWindPower(Integer maxWindPower) {
		this.maxWindPower = maxWindPower;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public boolean isFitForSail() {
		if (getMaxWindPower() > 6
				|| "storm".equals(getTyping())
				|| getTemperature() < -10) {
			return false;
		}
		
		return true;
	}
}
