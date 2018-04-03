package com.fof.biz.model.user;

import java.sql.Timestamp;

public class UserVO {
	private int idx;
	private String email;
	private String password;
	private String nickname;
	private int point;
	private int grade;
	private Timestamp regDate;
	private Timestamp lastLoginDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public UserVO(int idx, String email, String password, String nickname, int point, int grade, Timestamp regDate,
			Timestamp lastLoginDate) {
		super();
		this.idx = idx;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.point = point;
		this.grade = grade;
		this.regDate = regDate;
		this.lastLoginDate = lastLoginDate;
	}
	public UserVO() {
		super();
	}
	public UserVO(int idx) {
		super();
		this.idx = idx;
	}
	public UserVO(int idx, int point) {
		super();
		this.idx = idx;
		this.point = point;
	}
	@Override
	public String toString() {
		return "UserVO [idx=" + idx + ", email=" + email + ", password=" + password + ", nickname=" + nickname
				+ ", point=" + point + ", grade=" + grade + ", regDate=" + regDate + ", lastLoginDate=" + lastLoginDate
				+ "]";
	}
}
