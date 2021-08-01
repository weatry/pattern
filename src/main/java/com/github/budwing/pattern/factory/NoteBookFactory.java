package com.github.budwing.pattern.factory;

public class NoteBookFactory extends ComputerFactory {

	public CPU createCPU() {
		return new NoteBookCPU();
	}

	public HardDisk createHardDisk() {
		return new NoteBookHardDisk();
	}

	public Memery createMemery() {
		return new NoteBookMemery();
	}

}
