package org.zerock.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {} // basicOnlyGet.jsp로 이동
	
	@GetMapping("/ex04Form")
	public void ex04Form() {} // ex04Form.jsp로 이동
	@PostMapping("/ex04Form")
	public String ex04FormPost(SampleDTO dto, RedirectAttributes rttr) {
		log.info(dto);
		rttr.addFlashAttribute("dto", dto); // request.setAttribute("dto",dto)와 같은 역할
		rttr.addFlashAttribute("page", 10); // request.setAttribute("page",10)과 같은 역할
		return "redirect:/sample/ex04Result";
	}
	@GetMapping("/ex04Result")
	public void ex04Result() {} // ex04Result.jsp로 이동
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {

		log.info("dto: " + dto);
		log.info("page: " + page);

		return "/sample/ex04";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06..........");

		SampleDTO dto=new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07..........");

		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");

		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
}

