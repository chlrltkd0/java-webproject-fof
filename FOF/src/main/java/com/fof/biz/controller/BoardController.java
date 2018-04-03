package com.fof.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fof.biz.model.board.BoardCategoryService;
import com.fof.biz.model.board.BoardCategoryVO;
import com.fof.biz.model.board.BoardListVO;
import com.fof.biz.model.board.BoardService;
import com.fof.biz.model.board.BoardVO;
import com.fof.biz.model.user.UserVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	@Autowired
	private BoardCategoryService bcService;
	
	@RequestMapping("getBoardCategoryList.do")
	@ResponseBody
	public List<BoardCategoryVO> getBoardCategoryList() {
		System.out.println("log getBoartdCategoryList");
		return bcService.getBoardCategoryList();
	}
	
	@RequestMapping("writeBoard.do")
	@ResponseBody
	public boolean writeBoard(BoardVO bvo, HttpSession session) {
		System.out.println(bvo);
		UserVO uvo = (UserVO)session.getAttribute("user");
		return bService.writeBoard(bvo, uvo);
	}
	
	@RequestMapping("updateBoard.do")
	@ResponseBody
	public boolean updateBoard(BoardVO bvo) {
		bService.updateBoard(bvo);
		return true;
	}
	
	@RequestMapping("deleteBoard.do")
	@ResponseBody
	public boolean deleteBoard(BoardVO bvo) {
		bService.deleteBoard(bvo);
		return true;
	}
	
	@RequestMapping("getBoard.do")
	@ResponseBody
	public BoardVO getBoard(BoardVO bvo) {
		return bService.getBoard(bvo);
	}
	
	@RequestMapping("getBoardList.do")
	@ResponseBody
	public BoardListVO getBoardList(BoardListVO blvo) {
		System.out.println(blvo);
		BoardListVO bbbvo = bService.getBoardList(blvo);
		System.out.println(bbbvo);
		return bbbvo;
	}

}
