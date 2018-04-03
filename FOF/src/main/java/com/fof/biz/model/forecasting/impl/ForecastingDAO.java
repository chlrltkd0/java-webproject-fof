package com.fof.biz.model.forecasting.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fof.biz.model.forecasting.ForecastingVO;

@Repository
public class ForecastingDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertForecasting(ForecastingVO fvo) {
		return mybatis.insert("ForecastingDAO.insertForecasting", fvo);
	}
	
	public int deleteForecasting(ForecastingVO fvo) {
		return mybatis.delete("ForecastingDAO.deleteForecasting", fvo);
	}
	
	public int updateForecasting(ForecastingVO fvo) {
		return mybatis.update("ForecastingDAO.updateForecasting", fvo);
	}
	
	public ForecastingVO getForecasting(ForecastingVO fvo){
		return mybatis.selectOne("ForecastingDAO.getForecasting", fvo);
	}
	
	public ForecastingVO getForecastingWithBetting(ForecastingVO fvo){
		return mybatis.selectOne("ForecastingDAO.getForecastingWithBetting", fvo);
	}
	
	public List<ForecastingVO> getForecastingList(){
		return mybatis.selectList("ForecastingDAO.getForecastingList");
	}
}
