package com.github.budwing.pattern.command;

public class Demo {

	public static void main(String[] args) {
		Fan fan = new Fan();
		Light light = new Light();
		House house = new House(fan, light);
		
		house.execute(new LightTurnOnCommand(light));
		house.undo();
		house.redo();
		house.execute(new FanStartCommand(fan));
		house.undo();
		house.redo();
		house.execute(new FanSpeedUpCommand(fan));
		house.undo();
		house.redo();
		house.execute(new FanSlowDownCommand(fan));
		house.undo();
		house.redo();
		house.execute(new FanStopCommand(fan));
		
		house.undo();
		house.undo();
		house.redo();
		
	}

}
