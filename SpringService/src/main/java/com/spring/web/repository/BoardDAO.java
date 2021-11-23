package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	List<BoardVO> articles = new ArrayList<>();
	
	@Override
	public List<BoardVO> getArticles() {
		System.out.println("getArticles BoardDAO 실행");
		return articles;
	}

	@Override
	public void insertArticle(BoardVO board) {
		System.out.println("insertAricle BoardDAO 실행");
		articles.add(board);

	}

	@Override
	public void deleteArticle(int index) {
		System.out.println("deleteArticle BoardDAO 실행");
		articles.remove(index+1);

	}

	@Override
	public BoardVO getArticle(int index) {
		System.out.println("getArticle BoardDAO 실행");
		return articles.get(index);
	}

	@Override
	public void updateArticle(BoardVO board, int index) {
		System.out.println("updateArticle BoardDAO 실행");
		articles.add(index, board);
	}

}
