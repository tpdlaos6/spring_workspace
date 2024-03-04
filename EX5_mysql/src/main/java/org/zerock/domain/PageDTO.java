package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next; // 이전, 다음 링크 유무

	private int total; // 전체 글 수
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		
		//끝페이지
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		//시작 페이지
		this.startPage=this.endPage-9;
		
		//실제 끝 페이지. 아래 total*1.0->정수를 실수로 변환하기 위한 tip.. 메서드로 구현하지 않고, 이렇게 간단히 가능
		int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd<=this.endPage) {
			this.endPage=realEnd; //실제 끝 페이지가, end페이지보다 작으면... end페이지가 실제 끝페이지로
		}
		this.prev=this.startPage>1; // 시작 페이지가 1보다 커야(11부터) prev 존재
		this.next=this.endPage<realEnd; // end페이지가 실제 끝 페이지보다 작아야 next 존재
	}

}
