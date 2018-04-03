package com.fof.biz.model.board;

import com.fof.biz.model.user.UserVO;

public interface BoardService {
	boolean writeBoard(BoardVO bvo, UserVO session);
	boolean deleteBoard(BoardVO bvo);
	boolean updateBoard(BoardVO bvo);
	BoardVO getBoard(BoardVO bvo);
	BoardListVO getBoardList(BoardListVO bsvo);
}
