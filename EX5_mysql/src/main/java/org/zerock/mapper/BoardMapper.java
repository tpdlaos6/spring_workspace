package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//목록. 기본값은 List인데, BoardVO가 담겨있다고 생각하면 됨
	public List<BoardVO> getList();
	
	//상세보기
	public BoardVO read(Long bno);


}
