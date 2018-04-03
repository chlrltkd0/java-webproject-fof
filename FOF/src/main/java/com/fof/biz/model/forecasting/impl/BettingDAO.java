package com.fof.biz.model.forecasting.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fof.biz.model.forecasting.BettingVO;

@Repository
public class BettingDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertBetting(BettingVO bvo) {
		return mybatis.insert("BettingDAO.insertBetting", bvo);
	}
	
	public int deleteBetting(BettingVO bvo) {
		return mybatis.delete("BettingDAO.deleteBetting", bvo);
	}
	
	public int updateBetting(BettingVO bvo) {
		return mybatis.update("BettingDAO.updateBetting", bvo);
	}
	
	public BettingVO getBetting(BettingVO bvo){
		return mybatis.selectOne("BettingDAO.getBetting", bvo);
	}
}
