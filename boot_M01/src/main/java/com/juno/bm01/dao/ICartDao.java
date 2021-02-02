package com.juno.bm01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Cart;

@Mapper
public interface ICartDao {
	int insertCart(Cart c);
	List<Cart> listCart(String id);
	void deleteCart(String cseq);
}
