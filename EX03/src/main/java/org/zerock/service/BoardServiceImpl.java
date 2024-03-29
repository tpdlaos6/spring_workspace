package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
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

	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1; // 영향을 받은 행의 수가 1이면, 삭제가 성공
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board)==1; // 영향을 받은 행의 수가 1이면, 수정이 성공
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

}
