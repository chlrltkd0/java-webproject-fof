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
			} // �Ͼ�� ������ǿ� �̷��Ա��� ������ �ؾߵǳ�.... �ͱ⵵�ϰ�..
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
				} // �Ͼ�� ������ǿ� �̷��Ա��� ������ �ؾߵǳ�.... �ͱ⵵�ϰ�..
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
				 * ���⼭ ��ġ�°� �����ϴµ� �װԹ��ĸ� end Į���̶� answer Į���� ������ �Ȱ��� endĮ���� ���ְ� 
				 * answer Į���� ���� ����������� end������ true �̷��� �����ص��� ��, answerĮ���� ���� �ִ��� ������ �� ����
				 * �̷��� ���Ḧ �Ǵ��Ҽ� ����... �ϴ� �������� ���̱� ��������� �̷��� �����. ������ �ʿ��ϸ� ����.
				 * */
			}
		}
		return result;
	}
}
