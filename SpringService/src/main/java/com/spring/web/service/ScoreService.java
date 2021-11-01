package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.ScoreVO;
import com.spring.web.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {
	
	//서비스와 dao는 의존관계 됨
	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO scores) {
		scores.calcData();
		dao.insertScore(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteScore(int stuNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
