package com.juno.bg13.util;

import lombok.Data;

@Data
public class Paging {
	private int page;
    private int totalCount;
    private int beginPage;
    private int endPage;
    private int displayRow = 10;
    private int displayPage = 10;
    private int startNum;
    private int endNum;
    private boolean prev;
    private boolean next;
    
    public void calc() {
    	endPage = ((int)Math.ceil(page/(double)displayPage)) * displayPage;
    	beginPage = endPage - (displayPage - 1);
    	
    	int totalPage = (int)Math.ceil(totalCount / (double) displayRow);
    	
    	if (totalPage < endPage) {
    		endPage = totalPage;
    		next = false;
    	} else {
    		next = true;
    	}
    	prev = beginPage != 1;
    	startNum = (page - 1) * displayRow + 1;
    	endNum = page * displayRow;
    }
}
