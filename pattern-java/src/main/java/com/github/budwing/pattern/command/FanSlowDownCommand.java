package com.github.budwing.pattern.command;

public class FanSlowDownCommand extends Command {
	private Fan fan;

	public FanSlowDownCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	public void execute() {
		fan.slowdown();
	}

	public void undo() {
		fan.speedup();
	}

}
