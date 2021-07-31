package com.github.budwing.pattern.monitor.service;

import com.github.budwing.pattern.monitor.vo.Buying;
import com.github.budwing.pattern.monitor.vo.Quotation;
import com.github.budwing.pattern.monitor.vo.Stock;

import java.util.List;

public interface QuotationService {
	public List<Quotation> getQuotations(List<Stock> stocks) throws Exception;
	public Quotation getQuotation(Stock stock) throws Exception;
	public void refresh(List<Buying> buyings) throws Exception;
}
