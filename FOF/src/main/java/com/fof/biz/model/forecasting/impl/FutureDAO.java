package com.fof.biz.model.forecasting.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fof.biz.model.forecasting.BettingVO;
import com.fof.biz.model.forecasting.FutureVO;

@Repository
public class FutureDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertFuture(FutureVO fvo) {
		return mybatis.insert("FutureDAO.insertFuture", fvo);
	}
	
	public int deleteFuture(FutureVO fvo) {
		return mybatis.delete("FutureDAO.deleteFuture", fvo);
	}
	
	public int updateFuture(FutureVO fvo) {
		return mybatis.update("FutureDAO.updateFuture", fvo);
	}
	
	public int updateAnswer(FutureVO fvo) {
		return mybatis.update("FutureDAO.updateAnswer", fvo);
	}
	
	public int updateBetClose(FutureVO fvo) {
		return mybatis.update("FutureDAO.updateBetClose", fvo);
	}
	
	public int updateEnd(FutureVO fvo) {
		return mybatis.update("FutureDAO.updateEnd", fvo);
	}
	
	public FutureVO getFuture(FutureVO fvo){
		return mybatis.selectOne("FutureDAO.getFuture", fvo);
	}
	
	public FutureVO getFutureWithForecasting(FutureVO fvo){
		return mybatis.selectOne("FutureDAO.getFutureWithForcasting", fvo);
	}
	
	public List<FutureVO> getFutureList(){
		return mybatis.selectList("FutureDAO.getFutureList");
	}
}
