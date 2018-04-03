package com.fof.biz.model.user;

public interface UserService {
	boolean register(UserVO uvo);
	boolean checkEmail(UserVO uvo);
	UserVO login(UserVO uvo);
	boolean plusPoint(UserVO uvo);
	boolean minusPoint(UserVO uvo);
}
