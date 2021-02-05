package com.juno.bg15.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransactionDAO1 {

	void pay(String id, int amount);

}
