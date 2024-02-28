package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service // 이게 없으면 500 에러. Internal server error. 꼭 써줘야 함
@AllArgsConstructor // 자동으로 모든 필드를 초기화하는 생성자를 만들어줌

public class BoardServiceImpl implements BoardService{
	// 얘들이 하는 일은 단지 mapper를 호출. mapper를 호출하기 위해선, mapper를 주입해야.
	// 생성자 주입을 위해서 생성자를 만들어줘야 하고, 이를 위해 15 line의 
	// @AllArgsConstructor를 작성후 임포트
	
	// 자동 주입
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}


}
