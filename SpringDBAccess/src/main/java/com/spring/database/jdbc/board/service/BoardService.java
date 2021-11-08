package com.spring.database.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private IBoardDAO dao;
	
	@Override
	public List<BoardVO> getBoardList() {
		
		return dao.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO board) {
		dao.insertBoard(board);

	}

}
