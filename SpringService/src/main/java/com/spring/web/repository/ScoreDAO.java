package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {
	
	private List<ScoreVO> scoreList = new ArrayList<ScoreVO>();

	@Override
	public void insertScore(ScoreVO scores) {
		System.out.println("insertScore 요청 확인");
		scoreList.add(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return null;
	}

	@Override
	public void deleteScore(int stuNum) {
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return null;
	}

}
