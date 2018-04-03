package com.fof.biz.model.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fof.biz.model.board.BoardCategoryService;
import com.fof.biz.model.board.BoardCategoryVO;

@Service
public class BoardCategoryServiceImpl implements BoardCategoryService {
	
	@Autowired
	private BoardCategoryDAO bcDAO;

	@Override
	public boolean createBoardCategory(BoardCategoryVO bcvo) {
		int result = bcDAO.insertBoardCategory(bcvo);
		if(result==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean deleteBoardCategory(BoardCategoryVO bcvo) {
		int result = bcDAO.deleteBoardCategory(bcvo);
		if(result==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateBoardCategory(BoardCategoryVO bcvo) {
		int result = bcDAO.updateBoardCategory(bcvo);
		if(result==0)
			return false;
		else
			return true;
	}

	@Override
	public List<BoardCategoryVO> getBoardCategoryList() {
		return bcDAO.getBoardCategoryList();
	}
	
	
}
