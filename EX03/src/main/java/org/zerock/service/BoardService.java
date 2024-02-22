package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
		//목록
		public List<BoardVO> getList();
		//등록
		public void register(BoardVO board);
		//상세보기
		public BoardVO get(Long bno);
		//삭제. 정상적으로 삭제가 됐으면 true, 그렇지 않으면 false
		public boolean remove(Long bno);
		//수정
		public boolean modify(BoardVO board);
		//전체글수
		public int getTotal(Criteria cri);
		//목록 with paging. 오버로딩이므로 에러 안뜸
		public List<BoardVO> getList(Criteria cri); 
}
