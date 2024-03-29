package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController // 모든 메서드의 return 값이 json or xml로 리턴 됨. 즉, view로 이동하지 않는다는 뜻
@RequestMapping("/sample")
@Log4j
public class SampleController {
	@GetMapping(value="/getSample")
	public SampleVO getSample() {
		return new SampleVO(112,"스타","로드");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1,10).mapToObj(i->new SampleVO(i,i+" First", i+" Last")).collect(Collectors.toList());
	}
	
	@PostMapping("/ticket")
	//@RequestBody는 client에서 전달된 데이터를 DTO에 저장할 때 필요
	public Ticket convert(@RequestBody Ticket ticket) {
		return ticket;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] { "category: " + cat, "productid: " + pid };
	}
	

}
