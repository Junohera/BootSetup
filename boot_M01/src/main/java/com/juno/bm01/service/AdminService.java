package com.juno.bm01.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IAdminDao;
import com.juno.bm01.dto.Member;
import com.juno.bm01.dto.Order;
import com.juno.bm01.dto.Paging;
import com.juno.bm01.dto.Product;
import com.juno.bm01.dto.Qna;

@Service
public class AdminService {
	
	@Autowired
	IAdminDao ad;

	public int workerCheck(String workId, String workPwd) {
		int result = 0;
		String pwd = ad.workerCheck(workId);
		if (workPwd == null) 
			result = -1;
		else if (workPwd.equals(pwd)) 
			result = 1;
		else if (!workPwd.equals(pwd)) 
			result = 0;
		
		return result;
	}
	
	public int selectTotalCnt(String tableName, String searchType, String searchWord) {
		return ad.selectTotalCnt(tableName, searchType, searchWord);
	}

	public void insertProduct(Product p) {
		ad.insertProduct(p);
	}

	public void updateProduct(Product p) {
		ad.updateProduct(p);
	}

	public void updateOrderResult(int odseq) {
		ad.updateOrderResult(odseq);
	}

	public void qnaAttachAnswer(Qna q) {
		ad.qnaAttachAnswer(q);
	}

	public ArrayList<Product> selectProduct(Paging paging, String searchType, String key) {
		return ad.selectProduct(paging, searchType, key);
	}
	
	public ArrayList<Order> selectOrder(Paging paging, String searchType, String key) {
		return ad.selectOrder(paging, searchType, key);
	}
	
	public ArrayList<Member> selectMember(Paging paging, String searchType, String key) {
		return ad.selectMember(paging, searchType, key);
	}
	
	public ArrayList<Qna> selectQna(Paging paging, String searchType, String key) {
		return ad.selectQna(paging, searchType, key);
	}

}
