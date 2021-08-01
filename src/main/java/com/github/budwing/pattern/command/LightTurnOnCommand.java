package com.github.budwing.pattern.command;

public class LightTurnOnCommand extends Command {
	
	private Light light;
	
	public LightTurnOnCommand(Light light) {
		super();
		this.light = light;
	}

	public void execute() {
		light.turnon();
	}

	public void undo() {
		light.turnoff();
	}

}
