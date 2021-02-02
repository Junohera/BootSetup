package com.juno.bm01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IOrderDao;
import com.juno.bm01.dto.Cart;
import com.juno.bm01.dto.Order;

@Service
public class OrderService {
	
	@Autowired
	IOrderDao od;

	public int insertOrders(List<Cart> cartList, String id) {
		int oseq = 0;
		od.insertOrders(id);
		oseq = od.lookupMaxOseq();
		for (Cart c: cartList) {
			od.insertOrderDetail(c, oseq);
			od.updateCart(c.getCseq());
		}
		return oseq;
	}
	
	public List<Order> listOrderById(String id, String result, int oseq) {
		return od.listOrderById(id, result, oseq);
	}

	public ArrayList<Order> orderIng(String id) {
		ArrayList<Order> list = new ArrayList<Order>();
		
		for (int masterOseq: od.orderMasterByIdAndResult(id, "1")) { // 진행중인 것만
			
			List<Order> orderDetails = od.selectOrderDetail(masterOseq);
			if (orderDetails.size() > 0) {
				Order first = orderDetails.get(0);
				
				// 총 금액 
				int totalPrice = 0;
				for (Order od: orderDetails) {
					totalPrice += od.getPrice2() * od.getQuantity();
				}
				first.setPrice2(totalPrice);
				
				// 이름 변경
				if (orderDetails.size() > 1) {
					first.setPname(first.getPname() + " 외 " + (orderDetails.size() - 1) + "건");
				}
				
				list.add(first);	
			}
		}
		
		return list;
	}

	public ArrayList<Order> orderAll(String id) {
		ArrayList<Order> list = new ArrayList<Order>();
		
		// 1. 현재 로그인한 유저의 아이디로 모든 주문번호를 검색(중복없이)
		for (int masterOseq: od.orderMasterById(id)) { // 모든 주문
			
			// 2. 주문번호마다 주문상세내역을 받고
			List<Order> orderDetails = od.selectOrderDetail(masterOseq);
			
			// 3. 주문상세내역의 첫번째 상품이름 + 외 n건을 담아 적용
			Order first = orderDetails.get(0);
			
			int totalPrice = 0;
			for (Order od: orderDetails) {
				totalPrice += od.getPrice2() * od.getQuantity();
			}
			first.setPrice2(totalPrice);
			
			if (orderDetails.size() > 1) {
				first.setPname(first.getPname() + " 외 " + (orderDetails.size() - 1) + "건");
			}
			
			list.add(first);
		}
		
		return list;
	}

}
