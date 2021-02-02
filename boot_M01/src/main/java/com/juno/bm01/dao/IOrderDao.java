package com.juno.bm01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Cart;
import com.juno.bm01.dto.Order;

@Mapper
public interface IOrderDao {
	int insertOrders(String id);
	int lookupMaxOseq();
	int insertOrderDetail(Cart c, int oseq);
	int updateCart(int cseq);
	List<Order> listOrderById(String id, String result, int oseq);
	List<Integer> orderMasterByIdAndResult(String id, String string);
	List<Integer> orderMasterById(String id);
	List<Order> selectOrderDetail(int masterOseq);
}
