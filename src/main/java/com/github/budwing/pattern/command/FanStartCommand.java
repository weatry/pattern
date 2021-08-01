package com.github.budwing.pattern.command;

public class FanStartCommand extends Command {
	private Fan fan;

	public FanStartCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	public void execute() {
		fan.start();
	}

	public void undo() {
		fan.stop();
	}

}
