package com.bono.domain;


import lombok.Data;

@Data
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private Criteria criteria;
	
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		this.endPage = (int)(Math.ceil(criteria.getPageNum()/10.0))*10;
		
		this.startPage = this.endPage-9;
		if(this.startPage<=0) {
			this.startPage = 1;
		}
		
		int realEnd = (int) (Math.ceil((total * 10)/criteria.getAmount()));
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
