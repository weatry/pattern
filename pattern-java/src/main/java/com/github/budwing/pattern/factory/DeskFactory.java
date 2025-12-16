package com.github.budwing.pattern.factory;

public class DeskFactory extends ComputerFactory {

	public CPU createCPU() {
		return new DeskCPU();
	}

	public HardDisk createHardDisk() {
		return new DeskHardDisk();
	}

	public Memery createMemery() {
		return new DeskMemery();
	}

}
