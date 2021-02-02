package com.juno.bm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.ICartDao;
import com.juno.bm01.dto.Cart;

@Service
public class CartService {
	
	@Autowired
	ICartDao cd;

	public int insertCart(Cart c) {
		return cd.insertCart(c);
	}
	
	public List<Cart> listCart(String id) {
		return cd.listCart(id);
	}

	public void deleteCart(String cseq) {
		cd.deleteCart(cseq);
	}
	
	

}
