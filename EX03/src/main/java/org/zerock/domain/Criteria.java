package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	  private int pageNum; // 페이지 번호
	  private int amount; // 한 페이지에 출력되는 글 수
	  
	  private String type; // 검색컬럼. title, content, writer
	  private String keyword; // 검색어
	  
	  public Criteria() {
	    this(1, 10);
	  }
	  
	  public Criteria(int pageNum, int amount) {
		    this.pageNum = pageNum;
		    this.amount = amount;
		  }
	  
	  // 'TCW' => {'T','C','W'} 로 split
	  public String[] getTypeArr() {
		  return type==null? new String[] {}:type.split("");
	  }
	  
	  

}
