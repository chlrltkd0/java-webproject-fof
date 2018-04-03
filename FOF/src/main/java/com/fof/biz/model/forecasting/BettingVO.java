package com.fof.biz.model.forecasting;

import java.sql.Timestamp;

public class BettingVO {
	private int idx;
	private int futureIdx;
	private int forecastingIdx;
	private int userIdx;
	private int money;
	private Timestamp betDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getFutureIdx() {
		return futureIdx;
	}
	public void setFutureIdx(int futureIdx) {
		this.futureIdx = futureIdx;
	}
	public int getForecastingIdx() {
		return forecastingIdx;
	}
	public void setForecastingIdx(int forecastingIdx) {
		this.forecastingIdx = forecastingIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Timestamp getBetDate() {
		return betDate;
	}
	public void setBetDate(Timestamp betDate) {
		this.betDate = betDate;
	}
	public BettingVO(int idx, int futureIdx, int forecastingIdx, int userIdx, int money, Timestamp betDate) {
		super();
		this.idx = idx;
		this.futureIdx = futureIdx;
		this.forecastingIdx = forecastingIdx;
		this.userIdx = userIdx;
		this.money = money;
		this.betDate = betDate;
	}
	public BettingVO() {
		super();
	}
	@Override
	public String toString() {
		return "BettingVO [idx=" + idx + ", futureIdx=" + futureIdx + ", forecastingIdx=" + forecastingIdx
				+ ", userIdx=" + userIdx + ", money=" + money + ", betDate=" + betDate + "]";
	}
}
