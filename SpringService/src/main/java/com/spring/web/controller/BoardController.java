package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private IBoardService dao;
	
	//전체글 조회
	@GetMapping("/list")
	public String articleList(Model model, RedirectAttributes ra ) {
		model.addAttribute("articles", dao.getArticles());
		return "/board/list";
	}
	
	@GetMapping("content")
	public String content(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/content?boardNo=" + boardNo + ": GET 요청");
		model.addAttribute("article", dao.getArticle(boardNo));
		return "/content/content";
	}
	

	
	//요청화면 연결
	@GetMapping("/write")
	public void articleWrite() {
	}
	
	@PostMapping("/write")
	public String articleWrite(BoardVO board, Model model) {
		dao.insertArticle(board);
		
		return "redirect:/board/list";
	}
	
	//왜 GetMapping인데 파라미터를 받냐?
	//list.jsp에서 a링크로 파라미터를 묻혀서 줫기때문
	@GetMapping("delete")
	public String articleDelete(int boardNo) {
		dao.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	
	@GetMapping("modify")
	public String modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": GET 요청");
		model.addAttribute("article", dao.getArticle(boardNo));
		return "/content/modify";
	}
	
	@PostMapping("modify")
	public String modify(BoardVO board, int boardNo) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": POST 요청");
		dao.updateArticle(board, boardNo);
		return "redirect:/board/content?boardNo=" + boardNo;
	}

}
