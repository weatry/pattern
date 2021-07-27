package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

public interface PartitionWorker {

	public abstract boolean doPartition(FerryRequest request) throws Exception;

}