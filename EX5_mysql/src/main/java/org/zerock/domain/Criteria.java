package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Criteria { 
		private int pageNum=1; // page 번호
		private int amount=10; // 데이터가 몇 개냐
		
		public Criteria(int pageNum, int amount) {
			this.pageNum = pageNum;
			this.amount = amount;
		}
		
		
		//mybatis의 getSkip()함수로 페이징 처리
		public int getSkip() { 
			return (this.pageNum-1)*this.amount;
		}

	}
	
	
