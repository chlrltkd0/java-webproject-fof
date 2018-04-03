package com.fof.biz.model.forecasting.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fof.biz.model.forecasting.BettingVO;
import com.fof.biz.model.forecasting.FofService;
import com.fof.biz.model.forecasting.ForecastingVO;
import com.fof.biz.model.forecasting.FutureVO;
import com.fof.biz.model.user.UserService;
import com.fof.biz.model.user.UserVO;

@Service
public class FofServiceImpl implements FofService{

	@Autowired
	private FutureDAO futureDAO;
	@Autowired
	private ForecastingDAO forecastingDAO;
	@Autowired 
	private BettingDAO bettingDAO;
	@Autowired 
	private UserService uService;

	@Override
	public boolean createFuture(FutureVO fvo, UserVO uvo) {
		boolean result = false;
		if(uvo.getPoint() >= fvo.getDeposit()) {
			UserVO paramUvo = new UserVO(uvo.getIdx(), fvo.getDeposit());
			if(uService.minusPoint(paramUvo)) {
				fvo.setUserIdx(uvo.getIdx());
				uvo.setPoint(uvo.getPoint()+fvo.getDeposit());
				if(!(result = futureDAO.insertFuture(fvo)==0 ? false : true)) {
					uService.plusPoint(paramUvo);
					uvo.setPoint(uvo.getPoint()-fvo.getDeposit());
				};
			} // 일어나지 않을사건에 이렇게까지 검증을 해야되나.... 싶기도하고..
		}
		return result;
	}

	@Override
	public boolean createForecasting(ForecastingVO fvo, UserVO uvo) {
		boolean result = false;
		FutureVO checkfvo = futureDAO.getFuture(new FutureVO(fvo.getIdx()));
		if(!checkfvo.isEnd()) {
			result = forecastingDAO.insertForecasting(fvo)==0 ? false : true;
		}
		return result;
	}

	@Override
	public boolean bet(BettingVO bvo, UserVO uvo) {
		boolean result = false;

		FutureVO fvo = futureDAO.getFuture(new FutureVO(bvo.getFutureIdx()));
		if(!fvo.isBetClose()) {
			if(uvo.getPoint() >= bvo.getMoney()) {
				UserVO paramUvo = new UserVO(uvo.getIdx(), bvo.getMoney());
				if(uService.minusPoint(paramUvo)) {
					uvo.setPoint(uvo.getPoint()-fvo.getDeposit());
					bvo.setUserIdx(uvo.getIdx());
					if(!(result = bettingDAO.insertBetting(bvo)==0 ? false : true)) {
						uService.plusPoint(paramUvo);
						uvo.setPoint(uvo.getPoint()+fvo.getDeposit());
					};
				} // 일어나지 않을사건에 이렇게까지 검증을 해야되나.... 싶기도하고..
			}
		}
		return result;
	}

	@Override
	public boolean closeBet(FutureVO fvo, UserVO uvo) {
		boolean result = false;
		if(uvo.getIdx()==fvo.getUserIdx() || uvo.getGrade() >= 10) {
			result = futureDAO.updateBetClose(fvo)==0 ? false : true;
		}
		return result;
	} 

	@Override
	public boolean insertAnswer(FutureVO fvo, UserVO uvo) {
		boolean result = false;
		if(uvo.getGrade() >= 10) {
			FutureVO checkfvo = futureDAO.getFuture(fvo);
			if(!checkfvo.isEnd()) {
				result = futureDAO.updateAnswer(fvo)==0 ? false : true;
				ForecastingVO retfovo
					= forecastingDAO.getForecastingWithBetting(new ForecastingVO(fvo.getAnswer()));
				int pay = checkfvo.getDeposit()/retfovo.getListOfBetting().size();
				for(BettingVO bvo : retfovo.getListOfBetting()) {
					uService.plusPoint(new UserVO(bvo.getIdx(), pay));
				}
				futureDAO.updateEnd(fvo);
				/**
				 * 여기서 겹치는게 존재하는데 그게뭐냐면 end 칼럼이랑 answer 칼럼의 역할이 똑같음 end칼럼을 없애고 
				 * answer 칼럼에 값이 저장되있을시 end에서는 true 이렇게 저장해도됨 즉, answer칼럼에 값이 있는지 없는지 에 따라
				 * 미래의 종료를 판단할수 있음... 일단 가독성을 높이기 명시적으로 이렇게 써놓음. 수정이 필요하면 하자.
				 * */
			}
		}
		return result;
	}
}
