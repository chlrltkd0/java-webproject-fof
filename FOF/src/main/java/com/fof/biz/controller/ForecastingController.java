package com.fof.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fof.biz.model.forecasting.BettingVO;
import com.fof.biz.model.forecasting.FofService;
import com.fof.biz.model.forecasting.ForecastingVO;
import com.fof.biz.model.forecasting.FutureVO;
import com.fof.biz.model.user.UserVO;

@Controller
public class ForecastingController {
	
	@Autowired
	private FofService fService;
	
	@RequestMapping("createFuture.do")
	@ResponseBody
	public boolean createFuture(FutureVO fvo, HttpSession session) {
		UserVO uvo = (UserVO)session.getAttribute("user");
		return fService.createFuture(fvo, uvo);
	}
	
	@RequestMapping("createForecasting.do")
	@ResponseBody
	public boolean createForecasting(ForecastingVO fvo, HttpSession session) {
		UserVO uvo = (UserVO)session.getAttribute("user");
		return fService.createForecasting(fvo, uvo);
	}
	
	@RequestMapping("bet.do")
	@ResponseBody
	public boolean bet(BettingVO bvo, HttpSession session) {
		UserVO uvo = (UserVO)session.getAttribute("user");
		return fService.bet(bvo, uvo);
	}
	
	@RequestMapping("bet2.do")
	@ResponseBody
	public boolean insertAnswer(FutureVO fvo, HttpSession session) {
		UserVO uvo = (UserVO)session.getAttribute("user");
		return fService.insertAnswer(fvo, uvo);
	}

}
