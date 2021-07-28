package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryEntry;
import com.github.budwing.pattern.ferry.vo.FerryRequest;

public abstract class DataCollector {
	
	public abstract String collectEntry(FerryRequest request, FerryEntry entry) throws Exception;
}
