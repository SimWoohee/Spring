package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.ScoreVO;
import com.spring.web.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController{
	
	@Autowired
	private IScoreService dao;
	//구현클래스의 메소드를 호출하는것이 아니라 인터페이스의 메소드를 호출해야함! 규격화!
	
	//점수 등록 화면을 연결해주는 메소드
	@GetMapping("/register")
	public String register() {
		System.out.println("register : GET");
		return "/score/write-form";
	}
	
	//픔으로 부터 전달받은 파라미터 처리하기
	@PostMapping("register")	
	public void register(ScoreVO score) {
		System.out.println("register : POST");
		System.out.println(score.getStuName() + score);
		dao.insertScore(score);
	}
}
