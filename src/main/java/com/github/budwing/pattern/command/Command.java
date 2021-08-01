package com.github.budwing.pattern.command;

public abstract class Command {
	public abstract void execute();
	public abstract void undo();
}
