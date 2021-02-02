package com.juno.bm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IProductDao;
import com.juno.bm01.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	IProductDao pd;

	public List<Product> getNewList() {
		return pd.getNewList();
	}

	public List<Product> getBestList() {
		return pd.getBestList();
	}

}
