package com.spring.database.jdbc.score.commons;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.database.jdbc.score.model.ScoreVO;

//JDBC Template에서 ResultSet사용을 편하기 하기위한 클래스 생성.
public class ScoreMapper implements RowMapper<ScoreVO>{

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		//mapRow 안에는 어떻게 vo객체를 셋팅할건지만 정해주면됨!
		
		ScoreVO score = new ScoreVO();
		score.setStuId(rs.getInt("stu_id"));
		score.setStuName(rs.getString("stu_name"));
		score.setKor(rs.getInt("kor"));
		score.setEng(rs.getInt("eng"));
		score.setMath(rs.getInt("math"));
		score.setTotal(rs.getInt("total"));
		score.setAverage(rs.getDouble("average"));
		return score;
	}
	
	

}
