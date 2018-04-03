package com.fof.biz.model.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fof.biz.model.user.UserService;
import com.fof.biz.model.user.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insertUser(UserVO uvo) {
		return mybatis.insert("UserDAO.insertUser", uvo);
	}

	public UserVO getUserByEmail(UserVO uvo) {
		return mybatis.selectOne("UserDAO.getUserByEmail", uvo);
	}

	public UserVO getUserByEmailPw(UserVO uvo) {
		return mybatis.selectOne("UserDAO.getUserByEmailPw", uvo);
	}
	
	public UserVO getUserByIdx(UserVO uvo) {
		return mybatis.selectOne("UserDAO.getUserByIdx", uvo);
	}
	
	public int plusPoint(UserVO uvo) {
		return mybatis.update("UserDAO.plusPoint", uvo);
	}
	
	public int minusPoint(UserVO uvo) {
		return mybatis.update("UserDAO.minusPoint", uvo);
	}

}
