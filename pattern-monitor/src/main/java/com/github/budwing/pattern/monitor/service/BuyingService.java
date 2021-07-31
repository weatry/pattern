package com.github.budwing.pattern.monitor.service;

import com.github.budwing.pattern.monitor.vo.Buying;

import java.util.List;

public interface BuyingService {
	public List<Buying> getNotFinished() throws Exception;
	public List<Buying> getFinished() throws Exception;
	public Buying getWithSellingsById(String id);
	public void buy(Buying buy);
	public void editBuy(Buying buy);
	public void removeBuy(Buying buy);
	public void removeBuys(List<Buying> buys);
	public Float lossPrice(Float price, Integer amount);
	public Float targetPrice(Float price, Integer amount);
}
