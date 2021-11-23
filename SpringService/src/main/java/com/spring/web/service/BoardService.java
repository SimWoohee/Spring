package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.BoardVO;
import com.spring.web.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardDAO dao;
	
	@Override
	public List<BoardVO> getArticles() {
		System.out.println("getArticles BoardService 실행");
		return dao.getArticles();
	}

	@Override
	public void insertArticle(BoardVO board) {
			System.out.println("insertAricle BoardService 실행");
			dao.insertArticle(board);
	}

	@Override
	public void deleteArticle(int boardNo) {
		System.out.println("insertAricle BoardService 실행");
		dao.deleteArticle(boardNo - 1);

	}

	@Override
	public BoardVO getArticle(int boardNo) {
		return dao.getArticle(boardNo - 1);
	}

	@Override
	public void updateArticle(BoardVO board, int boardNo) {
		dao.updateArticle(board, boardNo-1);

	}


}
