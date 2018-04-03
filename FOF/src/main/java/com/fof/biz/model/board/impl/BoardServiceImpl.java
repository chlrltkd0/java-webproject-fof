package com.fof.biz.model.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fof.biz.model.board.BoardListVO;
import com.fof.biz.model.board.BoardService;
import com.fof.biz.model.board.BoardVO;
import com.fof.biz.model.user.UserVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public boolean writeBoard(BoardVO bvo, UserVO user) {
		bvo.setWriter(user.getNickname());
		bvo.setWriterIdx(user.getIdx());
		int result = boardDAO.insertBoard(bvo);
		if(result==0)
			return false;
		else
			return true;	
	}

	@Override
	public boolean deleteBoard(BoardVO bvo) {
		int result = boardDAO.deleteBoard(bvo);
		if(result==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateBoard(BoardVO bvo) {
		int result = boardDAO.updateBoard(bvo);
		if(result==0)
			return false;
		else
			return true;
	}

	@Override
	public BoardVO getBoard(BoardVO bvo) {
		return boardDAO.getBoard(bvo);
	}

	@Override
	public BoardListVO getBoardList(BoardListVO blvo) {
		int temp = blvo.getPage();
		blvo.setPage((temp-1)*10);
		blvo.setBoardCount(boardDAO.getBoardCount(blvo));
		blvo.setBoardList(boardDAO.getBoardList(blvo));
		blvo.setPage(temp);
		return blvo;
	}

}
