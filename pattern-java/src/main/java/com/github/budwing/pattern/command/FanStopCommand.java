package com.github.budwing.pattern.command;

public class FanStopCommand extends Command {
	private Fan fan;

	public FanStopCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	public void execute() {
		fan.stop();
	}

	public void undo() {
		fan.start();
	}

}
