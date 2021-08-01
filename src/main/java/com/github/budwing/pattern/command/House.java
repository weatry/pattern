package com.github.budwing.pattern.command;

import java.util.Vector;

public class House {
	private Fan fan;
	private Light light;
	private Vector<Command> undoList = new Vector<Command>();
	private Vector<Command> redoList = new Vector<Command>();

	public House(Fan fan, Light light) {
		super();
		this.fan = fan;
		this.light = light;
	}
	
	public void execute(Command command) {
		command.execute();
		undoList.add(command);
	}
	
	public void undo() {
		Command c = undoList.lastElement();
		if (c!=null) {
			c.undo();
			undoList.remove(c);
			redoList.add(c);
		}
	}
	
	public void redo() {
		Command c = redoList.lastElement();
		if (c!=null) {
			c.execute();
			redoList.remove(c);
			undoList.add(c);
		}
	}

}
