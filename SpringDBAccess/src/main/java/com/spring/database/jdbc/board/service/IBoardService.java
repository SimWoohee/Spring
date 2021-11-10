package com.spring.database.jdbc.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.database.jdbc.board.model.BoardVO;

public interface IBoardService {
	
	//전체 글 조회
		List<BoardVO> getBoardList();
		
		//글 작성
		void insertBoard(BoardVO board);
		
		void deleteBoard(int index);
		
		BoardVO getContent(int index);
		
		void updateBoard(BoardVO board);
		
		List<BoardVO> getSearchList(String keyword);
}
