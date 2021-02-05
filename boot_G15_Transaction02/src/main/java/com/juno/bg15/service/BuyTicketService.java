package com.juno.bg15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.juno.bg15.dao.ITransactionDAO1;
import com.juno.bg15.dao.ITransactionDAO2;

@Service
public class BuyTicketService implements IBuyTicketService {
	
	@Autowired
	ITransactionDAO1 tdao1;
	
	@Autowired
	ITransactionDAO2 tdao2;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Override
	public int buy(String id, int amount, String error) {
		
		try {
			tdao1.pay(id, amount);
			
			if (error.equals("1")) {
				int n = 10 / 0; // 의도적으로 강제 에러 발생
			} 
			
			tdao2.pay(id, amount);
			
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

}
