package com.fof.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fof.biz.model.user.UserService;
import com.fof.biz.model.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping("register.do")
	@ResponseBody
	public boolean register(UserVO uvo) {
		System.out.println("register : " +  uvo);
		return uService.register(uvo);
	}
	
	@RequestMapping("checkemail.do")
	@ResponseBody
	public String checkEmail(UserVO uvo) {
		System.out.println("checkemail : " +  uvo);
		return uService.checkEmail(uvo) + "";
	}
	
	@RequestMapping("login.do")
	@ResponseBody
	public UserVO login(UserVO uvo, HttpSession session) {
		UserVO retUVO = uService.login(uvo);
		if(retUVO != null) {
			session.setAttribute("user", retUVO);
			retUVO.setPassword("");
		}
		return retUVO;
	}
	
	@RequestMapping("logout.do")
	@ResponseBody
	public boolean logout(HttpSession session) {
		System.out.println("logout~!");
		session.invalidate();
		return true;
	}

}
