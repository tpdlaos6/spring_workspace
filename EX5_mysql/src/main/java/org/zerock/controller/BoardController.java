package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
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
//	@GetMapping("/list")
//	public void list(Model model) {
//		model.addAttribute("list", service.getList());
//	}
//	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri); // 전체 글 수
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	//상세보기
	@GetMapping({"/get","/modify"})
	public void get(Model model,Long bno) {
		model.addAttribute("board", service.get(bno));
	}
	
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		if(service.modify(board)) { //수정처리가 되었으면
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; //목록으로 이동
	}
	
	//삭제
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		if(service.remove(bno)) { //삭제처리가 되었으면
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; //목록으로 이동
	
	}
	
}
