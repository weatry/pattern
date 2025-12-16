package com.github.budwing.pattern.command;

public class FanSpeedUpCommand extends Command {
	private Fan fan;

	public FanSpeedUpCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	public void execute() {
		fan.speedup();
	}

	public void undo() {
		fan.slowdown();
	}

}
