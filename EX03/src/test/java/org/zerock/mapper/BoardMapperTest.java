package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTest {
	// 주입 방법은 3가지. 필드주입, setter주입, 생성자 주입... 에러나면 셋 중 하나 되는 걸로 해보면 됨. 롬복 문제일 가능성이 높음
//	@Setter(onMethod_= @Autowired)
	@Autowired
	private BoardMapper mapper; // 주입
	
	@Test
	public void testGetList() {
		// getList()의 return같은 List<BoardVO>
		// List에서 한 개씩 꺼내서 boardVO() 매개변수에 저장한 다음 log.info로 출력
		// -> 는 람다식.......... 자바에서도 람다식을.......
		mapper.getList().forEach(boardVo -> log.info(boardVo));
	}
	
	@Test
	public void testRead() {
		BoardVO board=mapper.read(5L);
		log.info(board);
	}

}
