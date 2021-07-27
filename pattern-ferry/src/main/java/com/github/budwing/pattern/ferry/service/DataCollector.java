package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryEntry;
import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.util.Date;

public abstract class DataCollector {
	
	public abstract String collectEntry(FerryRequest request, FerryEntry entry, Date execTime) throws Exception;
}
