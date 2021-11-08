package com.spring.database.jdbc.board.controller;

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
	
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("articles", service.getBoardList());
	}
	

}
