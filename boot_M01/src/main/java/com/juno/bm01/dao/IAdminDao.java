package com.juno.bm01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Member;
import com.juno.bm01.dto.Order;
import com.juno.bm01.dto.Paging;
import com.juno.bm01.dto.Product;
import com.juno.bm01.dto.Qna;

@Mapper
public interface IAdminDao {

	String workerCheck(String workId);

	int selectTotalCnt(String tableName, String searchType, String searchWord);

	ArrayList<Product> list(String tableName, Paging paging, String searchType, String key);

	void insertProduct(Product p);

	void updateProduct(Product p);

	void updateOrderResult(int odseq);

	void qnaAttachAnswer(Qna q);

	ArrayList<Product> selectProduct(Paging paging, String searchType, String key);

	ArrayList<Order> selectOrder(Paging paging, String searchType, String key);

	ArrayList<Member> selectMember(Paging paging, String searchType, String key);

	ArrayList<Qna> selectQna(Paging paging, String searchType, String key);
	
}
