package com.spring.database.jdbc.board.repository;

import java.util.List;

import com.spring.database.jdbc.board.model.BoardVO;

public interface IBoardMapper {

	//전체 글 조회
	List<BoardVO> getBoardList();

	//글 작성
	void insertBoard(BoardVO board);

	void deleteBoard(int index);

	BoardVO getContent(int index);

	void updateBoard(BoardVO board);

	List<BoardVO> getSearchList(String keyword);


}
