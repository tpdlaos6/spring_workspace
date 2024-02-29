package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
		//목록
		public List<BoardVO> getList();
		
		//상세보기
		public BoardVO get(Long bno);

}
