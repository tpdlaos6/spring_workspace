package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller

@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	//자동주입
	private BoardService service;
	
	//목록
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}

	//상세보기
	@GetMapping("/get")
	public void get(Model model,Long bno) {
		model.addAttribute("board", service.get(bno));
	}
	
	
	
}
