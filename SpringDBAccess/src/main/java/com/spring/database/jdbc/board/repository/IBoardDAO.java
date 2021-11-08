package com.spring.database.jdbc.board.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.board.model.BoardVO;

public interface IBoardDAO {
	
	//전체 글 조회
	List<BoardVO> getBoardList();
	
	//글 작성
	void insertBoard(BoardVO board);

}
