package com.juno.bm01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Product;

@Mapper
public interface IProductDao {
	List<Product> getNewList();
	List<Product> getBestList();
}
