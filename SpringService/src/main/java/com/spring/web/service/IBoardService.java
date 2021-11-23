package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.model.BoardVO;

public interface IBoardService {
	
	//게시글 목록 가져오기
	List<BoardVO> getArticles();
	
	//게시글 등록
	void insertArticle(BoardVO board);

	//게시글 삭제
	void deleteArticle(int boardNo);
	
	//게시글 내용보기
	BoardVO getArticle(int boardNo);
	
	//게시글 수정
	void updateArticle(BoardVO board, int boardNo);
}
