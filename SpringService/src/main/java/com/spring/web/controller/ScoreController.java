package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		System.out.println("/score/register : GET");
		return "/score/write-form";
	}
	
	//픔으로 부터 전달받은 파라미터 처리하기
	@PostMapping("register")	
	public String register(ScoreVO score) {
		System.out.println("/score/register : POST");
		System.out.println(score.getStuName() + score);
		dao.insertScore(score);
		
		return "/score/write-result";
	}
	
	//점수 전체 조회를 처리하는 요청 메소드
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/score/list : GET");
		model.addAttribute("sList", dao.selectAllScores());
		return "/score/list";
	}
	
	//점수 삭제 요청 처리 메서드
	@GetMapping("/delete")
	public String delete(int stuNum, RedirectAttributes ra) {
		System.out.println("/score/delete : GET");
		System.out.println("삭제할 학번 : " + stuNum);
		dao.deleteScore(stuNum);
		//삭제 후 alert창 표시하기위한 작업
		ra.addFlashAttribute("message", "delSuccess");
		
		//삭제 완료 후 list를 다시 갱신 해야하니깐 redirect하여 list 갱신
		return "redirect:/score/list";
	}
	
	////개발조회를 누르면 학번은 입력할 수 있는 창을 열어준다
	@GetMapping("/search")
	public void search() {
		System.out.println("/score/search : GET");
	}
	
	@PostMapping("/selectOne")
	public String selectOne(String stuNum, Model model, RedirectAttributes ra) {
		System.out.println("/score/selectOne : Post");
		List<ScoreVO> scoreList = dao.selectAllScores();
		try {
		//파라미터가 문자열이면 numberformatexception이 발생하여 
		//catch문에서 에러 문구 저장
		int n = Integer.parseInt(stuNum);
			//전체 list사이즈를 가져와서 학번과 비교하여 유효한 학번인지 체크하기!
			if(n > scoreList.size()) {
				ra.addFlashAttribute("msg", "학번정보가 유효하지 않습니다");
				return "redirect:/score/search";
			}else {
				model.addAttribute("score", dao.selectOne(n));
				return "/score/search-result";
			}
		} catch (NumberFormatException e) {
			ra.addFlashAttribute("msg", "숫자로만 입력하세요!");
			return "redirect:/score/search";
		}
		
		
	}
}
