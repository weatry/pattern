package com.github.budwing.pattern.factory;

public class ComputerFactoryInPrototype {
	public CPU createCPU(CPU cpu) throws Exception {
		return (CPU)cpu.clone();
	}
	public HardDisk createHardDisk(HardDisk disk) throws Exception {
		return (HardDisk)disk.clone();
	}
	public Memery createMemery(Memery m) throws Exception {
		return (Memery)m.clone();
	}
}
