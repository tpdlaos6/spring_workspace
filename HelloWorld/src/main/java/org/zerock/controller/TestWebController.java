package org.zerock.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class TestWebController {
	@GetMapping("/hello")
	public String hello() {
		return "hello"; // hello.jsp로 forwarding
	}
	
	@GetMapping("/hello2")
	@RequestMapping(value="/hello2",produces="application/json;charset=UTF-8") // 한글깨짐방지
	@ResponseBody // ResponseBody를 붙이면 화면으로 안간다는 말. 
	public String hello2(String msg) throws UnsupportedEncodingException{
			return msg; // msg라는 값이 클라이언트로 전송. view로 가는 게 아님!
	}
	
	@GetMapping("/hello3/{msg}")
	public String hello3(@PathVariable String msg, Model m) {
		m.addAttribute("msg",msg); // request.setAttribute("msg",msg)와 같은 역할
		return "hello"; // hello.jsp로 forwarding
	}
}
