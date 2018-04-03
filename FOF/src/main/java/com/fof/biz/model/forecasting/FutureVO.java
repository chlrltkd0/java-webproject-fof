package com.fof.biz.model.forecasting;

import java.sql.Timestamp;
import java.util.List;

public class FutureVO {
	private int idx;
	private int userIdx;
	private int categoryIdx;
	private String eventDescription;
	private int answer;
	private int deposit;
	private Timestamp regDate;
	private Timestamp deadline;
	private boolean betClose;
	private boolean end;
	private List<ForecastingVO> listOfForecasting;
	public int getIdx() {
		return idx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getDeadline() {
		return deadline;
	}
	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}
	public boolean isBetClose() {
		return betClose;
	}
	public void setBetClose(boolean betClose) {
		this.betClose = betClose;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public List<ForecastingVO> getListOfForecasting() {
		return listOfForecasting;
	}
	public void setListOfForecasting(List<ForecastingVO> listOfForecasting) {
		this.listOfForecasting = listOfForecasting;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public FutureVO(int idx, int userIdx, int categoryIdx, String eventDescription, int answer, int deposit,
			Timestamp regDate, Timestamp deadline, boolean betClose, boolean end,
			List<ForecastingVO> listOfForecasting) {
		super();
		this.idx = idx;
		this.userIdx = userIdx;
		this.categoryIdx = categoryIdx;
		this.eventDescription = eventDescription;
		this.answer = answer;
		this.deposit = deposit;
		this.regDate = regDate;
		this.deadline = deadline;
		this.betClose = betClose;
		this.end = end;
		this.listOfForecasting = listOfForecasting;
	}
	public FutureVO() {
		super();
	}
	public FutureVO(int idx) {
		super();
		this.idx = idx;
	}
	@Override
	public String toString() {
		return "FutureVO [idx=" + idx + ", userIdx=" + userIdx + ", categoryIdx=" + categoryIdx + ", eventDescription="
				+ eventDescription + ", answer=" + answer + ", deposit=" + deposit + ", regDate=" + regDate
				+ ", deadline=" + deadline + ", betClose=" + betClose + ", end=" + end + ", listOfForecasting="
				+ listOfForecasting + "]";
	}
}
