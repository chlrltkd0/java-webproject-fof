package com.fof.biz.model.board;

import java.util.List;

public interface BoardCategoryService {
	boolean createBoardCategory(BoardCategoryVO bcvo);
	boolean deleteBoardCategory(BoardCategoryVO bcvo);
	boolean updateBoardCategory(BoardCategoryVO bcvo);
	List<BoardCategoryVO> getBoardCategoryList();

}
