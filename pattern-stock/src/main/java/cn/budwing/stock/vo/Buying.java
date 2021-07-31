package cn.budwing.stock.vo;

// Generated 2014-12-6 22:33:32 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.List;

public class Buying implements java.io.Serializable {

	private String id;
	private String stockId;
	private String stockCode;
	private String stockName;
	private Date date;
	private Float price;
	private Integer amount;
	private Float lossPrice;
	private Float targetPrice;
	private Integer holdDays;
	private String notes;
	
	private List<Selling> sellings;

	public Buying() {
	}

	public Buying(String id) {
		this.id = id;
	}

	public Buying(String stockId, String stockCode,
			String stockName, Date date, Float price, Integer amount,
			Float lossPrice, Float targetPrice, Integer holdDays, String notes) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.date = date;
		this.price = price;
		this.amount = amount;
		this.lossPrice = lossPrice;
		this.targetPrice = targetPrice;
		this.holdDays = holdDays;
		this.notes = notes;
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Selling> getSellings() {
		return sellings;
	}

	public void setSellings(List<Selling> sellings) {
		this.sellings = sellings;
	}

}
