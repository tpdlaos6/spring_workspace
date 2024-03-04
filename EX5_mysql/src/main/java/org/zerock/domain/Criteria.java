package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
		private int pageNum;
		private int amount;
		private int skipCount; // 연산한 값을 담아 파라미터로 넘겨줌
		
		public Criteria() {
			this(1,10);
		}
		
		public Criteria(int pageNum, int amount) {
			this.pageNum = pageNum;
			this.amount = amount;
			this.getSkipCount(pageNum, amount); // 값을 getSkipCount에 담음
		}

		public int getSkipCount(int pageNum, int amount) { 
			return skipCount = (pageNum-1) * amount;
		}
		
	}
	
	
