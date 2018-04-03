package com.fof.biz.model.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fof.biz.model.user.UserService;
import com.fof.biz.model.user.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean register(UserVO uvo) {
		boolean result = userDAO.insertUser(uvo)==0 ? false : true;
		return result; // booleanÀ¸·Î ¹Ù²ã¾ß‰Î
	}

	@Override
	public boolean checkEmail(UserVO uvo) {
		boolean result = userDAO.getUserByEmail(uvo)==null ? true : false;
		return result;
	}

	@Override
	public UserVO login(UserVO uvo) {
		return userDAO.getUserByEmailPw(uvo);
	}

	@Override
	public boolean plusPoint(UserVO uvo) {
		boolean result = userDAO.plusPoint(uvo)==0 ? false : true;
		return result;
	}

	@Override
	public boolean minusPoint(UserVO uvo) {
		UserVO checkuvo = userDAO.getUserByIdx(uvo);
		boolean result = false;
		if(uvo.getPoint() <= checkuvo.getPoint()) {
			result = userDAO.minusPoint(uvo)==0 ? false : true;
		}
		return result;
	}

}
