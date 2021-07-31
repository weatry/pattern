package com.github.budwing.pattern.monitor.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
0：”大秦铁路”，股票名字；
1：”27.55″，今日开盘价；
2：”27.25″，昨日收盘价；
3：”26.91″，当前价格；
4：”27.55″，今日最高价；
5：”26.20″，今日最低价；
6：”26.91″，竞买价，即“买一”报价；
7：”26.92″，竞卖价，即“卖一”报价；
8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
10：”4695″，“买一”申请4695股，即47手；
11：”26.91″，“买一”报价；
12：”57590″，“买二”
13：”26.90″，“买二”
14：”14700″，“买三”
15：”26.89″，“买三”
16：”14300″，“买四”
17：”26.88″，“买四”
18：”15100″，“买五”
19：”26.87″，“买五”
20：”3100″，“卖一”申报3100股，即31手；
21：”26.92″，“卖一”报价
(22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
30：”2008-01-11″，日期；
31：”15:05:32″，时间；
*/
public class Quotation {
	private String stockCode;				//.
	private String stockName;               //0
	private Float  todayOpeningPrice;       //1
	private Float  yesterdayClosingPrice;   //2
	private Float  currentPrice;            //3
	private Float  maxPrice;                //4
	private Float  minPrice;                //5
	private Float  buyPrice;                //6
	private Float  salePrice;               //7
	private Long   volume;                  //8
	private Float  amount;                  //9
	private Long   buy1Volume;              //10
	private Float  buy1Price;               //11
	private Long   buy2Volume;              //12
	private Float  buy2Price;               //13
	private Long   buy3Volume;              //14
	private Float  buy3Price;               //15
	private Long   buy4Volume;              //16
	private Float  buy4Price;               //17
	private Long   buy5Volume;              //18
	private Float  buy5Price;               //19
	private Long   sale1Volume;             //20
	private Float  sale1Price;              //21
	private Long   sale2Volume;             //22
	private Float  sale2Price;              //23
	private Long   sale3Volume;             //24
	private Float  sale3Price;              //25
	private Long   sale4Volume;             //26
	private Float  sale4Price;              //27
	private Long   sale5Volume;             //28
	private Float  sale5Price;              //29
	private Date   dateTime;
	
	public static Quotation build(String[] contents) {
		Quotation result = new Quotation();
		result.stockName             = contents[0 ];
		result.todayOpeningPrice     = Float.parseFloat(contents[1]);
		result.yesterdayClosingPrice = Float.parseFloat(contents[2]);
		result.currentPrice          = Float.parseFloat(contents[3]);
		result.maxPrice              = Float.parseFloat(contents[4]);
		result.minPrice              = Float.parseFloat(contents[5]);
		result.buyPrice              = Float.parseFloat(contents[6]);
		result.salePrice             = Float.parseFloat(contents[7]);
		result.volume                = Long.parseLong(contents[8]);
		result.amount                = Float.parseFloat(contents[9]);
		result.buy1Volume            = Long.parseLong(contents[10]);
		result.buy1Price             = Float.parseFloat(contents[11]);
		result.buy2Volume            = Long.parseLong(contents[12]); 
		result.buy2Price             = Float.parseFloat(contents[13]); 
		result.buy3Volume            = Long.parseLong(contents[14]); 
		result.buy3Price             = Float.parseFloat(contents[15]); 
		result.buy4Volume            = Long.parseLong(contents[16]); 
		result.buy4Price             = Float.parseFloat(contents[17]); 
		result.buy5Volume            = Long.parseLong(contents[18]); 
		result.buy5Price             = Float.parseFloat(contents[19]); 
		result.sale1Volume           = Long.parseLong(contents[20]); 
		result.sale1Price            = Float.parseFloat(contents[21]); 
		result.sale2Volume           = Long.parseLong(contents[22]); 
		result.sale2Price            = Float.parseFloat(contents[23]); 
		result.sale3Volume           = Long.parseLong(contents[24]); 
		result.sale3Price            = Float.parseFloat(contents[25]); 
		result.sale4Volume           = Long.parseLong(contents[26]); 
		result.sale4Price            = Float.parseFloat(contents[27]); 
		result.sale5Volume           = Long.parseLong(contents[28]); 
		result.sale5Price            = Float.parseFloat(contents[29]); 
		try {
			result.dateTime              = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(contents[30]+contents[31]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Float getTodayOpeningPrice() {
		return todayOpeningPrice;
	}

	public void setTodayOpeningPrice(Float todayOpeningPrice) {
		this.todayOpeningPrice = todayOpeningPrice;
	}

	public Float getYesterdayClosingPrice() {
		return yesterdayClosingPrice;
	}

	public void setYesterdayClosingPrice(Float yesterdayClosingPrice) {
		this.yesterdayClosingPrice = yesterdayClosingPrice;
	}

	public Float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}

	public Float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Long getBuy1Volume() {
		return buy1Volume;
	}

	public void setBuy1Volume(Long buy1Volume) {
		this.buy1Volume = buy1Volume;
	}

	public Float getBuy1Price() {
		return buy1Price;
	}

	public void setBuy1Price(Float buy1Price) {
		this.buy1Price = buy1Price;
	}

	public Long getBuy2Volume() {
		return buy2Volume;
	}

	public void setBuy2Volume(Long buy2Volume) {
		this.buy2Volume = buy2Volume;
	}

	public Float getBuy2Price() {
		return buy2Price;
	}

	public void setBuy2Price(Float buy2Price) {
		this.buy2Price = buy2Price;
	}

	public Long getBuy3Volume() {
		return buy3Volume;
	}

	public void setBuy3Volume(Long buy3Volume) {
		this.buy3Volume = buy3Volume;
	}

	public Float getBuy3Price() {
		return buy3Price;
	}

	public void setBuy3Price(Float buy3Price) {
		this.buy3Price = buy3Price;
	}

	public Long getBuy4Volume() {
		return buy4Volume;
	}

	public void setBuy4Volume(Long buy4Volume) {
		this.buy4Volume = buy4Volume;
	}

	public Float getBuy4Price() {
		return buy4Price;
	}

	public void setBuy4Price(Float buy4Price) {
		this.buy4Price = buy4Price;
	}

	public Long getBuy5Volume() {
		return buy5Volume;
	}

	public void setBuy5Volume(Long buy5Volume) {
		this.buy5Volume = buy5Volume;
	}

	public Float getBuy5Price() {
		return buy5Price;
	}

	public void setBuy5Price(Float buy5Price) {
		this.buy5Price = buy5Price;
	}

	public Long getSale1Volume() {
		return sale1Volume;
	}

	public void setSale1Volume(Long sale1Volume) {
		this.sale1Volume = sale1Volume;
	}

	public Float getSale1Price() {
		return sale1Price;
	}

	public void setSale1Price(Float sale1Price) {
		this.sale1Price = sale1Price;
	}

	public Long getSale2Volume() {
		return sale2Volume;
	}

	public void setSale2Volume(Long sale2Volume) {
		this.sale2Volume = sale2Volume;
	}

	public Float getSale2Price() {
		return sale2Price;
	}

	public void setSale2Price(Float sale2Price) {
		this.sale2Price = sale2Price;
	}

	public Long getSale3Volume() {
		return sale3Volume;
	}

	public void setSale3Volume(Long sale3Volume) {
		this.sale3Volume = sale3Volume;
	}

	public Float getSale3Price() {
		return sale3Price;
	}

	public void setSale3Price(Float sale3Price) {
		this.sale3Price = sale3Price;
	}

	public Long getSale4Volume() {
		return sale4Volume;
	}

	public void setSale4Volume(Long sale4Volume) {
		this.sale4Volume = sale4Volume;
	}

	public Float getSale4Price() {
		return sale4Price;
	}

	public void setSale4Price(Float sale4Price) {
		this.sale4Price = sale4Price;
	}

	public Long getSale5Volume() {
		return sale5Volume;
	}

	public void setSale5Volume(Long sale5Volume) {
		this.sale5Volume = sale5Volume;
	}

	public Float getSale5Price() {
		return sale5Price;
	}

	public void setSale5Price(Float sale5Price) {
		this.sale5Price = sale5Price;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
