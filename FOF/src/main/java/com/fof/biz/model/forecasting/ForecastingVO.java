package com.fof.biz.model.forecasting;

import java.util.List;

public class ForecastingVO {
	private int idx;
	private int futureIdx;
	private String forecastingDescription;
	private double dividend;
	private List<BettingVO> listOfBetting;
	
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
	public String getForecastingDescription() {
		return forecastingDescription;
	}
	public void setForecastingDescription(String forecastingDescription) {
		this.forecastingDescription = forecastingDescription;
	}
	public double getDividend() {
		return dividend;
	}
	public void setDividend(double dividend) {
		this.dividend = dividend;
	}
	public List<BettingVO> getListOfBetting() {
		return listOfBetting;
	}
	public void setListOfBetting(List<BettingVO> listOfBetting) {
		this.listOfBetting = listOfBetting;
	}
	public ForecastingVO(int idx, int futureIdx, String forecastingDescription, double dividend,
			List<BettingVO> listOfBetting) {
		super();
		this.idx = idx;
		this.futureIdx = futureIdx;
		this.forecastingDescription = forecastingDescription;
		this.dividend = dividend;
		this.listOfBetting = listOfBetting;
	}
	public ForecastingVO() {
		super();
	}
	public ForecastingVO(int idx) {
		super();
		this.idx = idx;
	}
	@Override
	public String toString() {
		return "ForecastingVO [idx=" + idx + ", futureIdx=" + futureIdx + ", forecastingDescription="
				+ forecastingDescription + ", dividend=" + dividend + ", listOfBetting=" + listOfBetting + "]";
	}
}
