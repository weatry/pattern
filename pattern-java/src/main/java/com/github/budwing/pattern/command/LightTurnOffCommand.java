package com.github.budwing.pattern.command;

public class LightTurnOffCommand extends Command {
	
	private Light light;
	
	public LightTurnOffCommand(Light light) {
		super();
		this.light = light;
	}

	public void execute() {
		light.turnoff();
	}

	public void undo() {
		light.turnon();
	}

}
