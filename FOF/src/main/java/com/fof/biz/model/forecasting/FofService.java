package com.fof.biz.model.forecasting;

import com.fof.biz.model.user.UserVO;

public interface FofService {
	boolean createFuture(FutureVO fvo, UserVO uvo);
	boolean createForecasting(ForecastingVO fvo, UserVO uvo);
	boolean bet(BettingVO bvo, UserVO uvo);
	boolean closeBet(FutureVO fvo, UserVO uvo);
	boolean insertAnswer(FutureVO fvo, UserVO uvo);
}
