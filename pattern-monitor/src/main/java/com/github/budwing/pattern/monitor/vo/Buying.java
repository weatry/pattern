package com.github.budwing.pattern.monitor.vo;

// Generated 2014-12-6 22:33:32 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.List;

public class Buying implements java.io.Serializable {

	private String  id;
	private String  stockId;
	private String  stockCode;
	private String  stockName;
	private Date    date;
	private Float   price;
	private Integer amount;
	private Float   fee = 0f;
	private Float   lossPrice;
	private Float   targetPrice;
	private Integer holdDays;
	private Boolean finished;
	private String  notes;
	
	//以下内容非数据库存储
	private Float currentPrice;
	private Integer availableAmount;
	private Float currentProfit;
	
	public Buying() {
	}

	public Buying(String id) {
		this.id = id;
	}
	
	public Stock createStock() {
		return new Stock(stockCode, stockName);
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
		this.availableAmount = amount;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Float getLossPrice() {
		return this.lossPrice;
	}

	public void setLossPrice(Float lossPrice) {
		this.lossPrice = lossPrice;
	}

	public Float getTargetPrice() {
		return this.targetPrice;
	}

	public void setTargetPrice(Float targetPrice) {
		this.targetPrice = targetPrice;
	}

	public Integer getHoldDays() {
		return this.holdDays;
	}

	public void setHoldDays(Integer holdDays) {
		this.holdDays = holdDays;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Integer availableAmount) {
		this.availableAmount = availableAmount;
	}

	public Float getCurrentProfit() {
		return currentProfit;
	}

	public void setCurrentProfit(Float currentProfit) {
		this.currentProfit = currentProfit;
	}

}
