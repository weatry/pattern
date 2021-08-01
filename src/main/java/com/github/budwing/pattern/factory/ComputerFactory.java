package com.github.budwing.pattern.factory;

public abstract class ComputerFactory {
	public abstract CPU createCPU();
	public abstract HardDisk createHardDisk();
	public abstract Memery createMemery();
}
