package com.spring.database.jdbc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	@GetMapping("/write")
	public void write() {
		System.out.println("write : GET 요청");		
	}
	
	@PostMapping("/write")
	public String write(BoardVO board) {
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	
	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("articles", service.getBoardList());
	}
	
	//글 삭제
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		int boardNo = boardVO.getBoardNo();
		service.deleteBoard(boardNo);
		return "redirect:/board/list";
	}
	
	//자세히보기
	@GetMapping("/content")
	public String content(BoardVO boardVO, Model model) {
		int boardNo = boardVO.getBoardNo();
		model.addAttribute("article", service.getContent(boardNo));
		return "/board/content";
		
	}
	

	//글 수정하기 화면요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+" : GET요청 발생!");

		model.addAttribute("article", service.getContent(boardNo));
		
	}

	//글 수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify?boardNo="+article.getBoardNo()+" : POST요청 발생!");
		service.updateBoard(article);
		return "redirect:/board/content?boardNo="+article.getBoardNo();
	}
	
	//게시글 검색 처리요청
	@GetMapping("/searchList")
	public String searchList(String keyword, Model model) {
		List<BoardVO> list = service.getSearchList(keyword);		
		model.addAttribute("articles", list);
		return "board/list";
	}
	

}
