package com.spring.mvc.user.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.spring.mvc.user.model.UserVO;

public interface IUserService {
	
	//회원가입 기능
	void regsiter(UserVO user);
	
	//삭제
	void delete(String account);
	
	//회원 조회
	UserVO select(String account);
	
	//회원 전체 조회
	List<UserVO> selectAll();
	
	//id 중복확인
	Integer checkId(String account);
	
	//회원정보 조회 기능
	UserVO selectOne(String account);
	
	//자동로그인 쿠키값 DB저장 처리
	void keepLogin(String sessionId, Date limitDate, String account);
	
	//세션id로 검색
	UserVO getUserWithSessionId(String sessionId);
			

}
