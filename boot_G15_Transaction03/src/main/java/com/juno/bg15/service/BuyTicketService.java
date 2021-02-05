package com.juno.bg15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.juno.bg15.dao.ITransactionDAO1;
import com.juno.bg15.dao.ITransactionDAO2;
import com.juno.bg15.dao.ITransactionDAO3;

@Service
public class BuyTicketService implements IBuyTicketService {
	
	@Autowired
	ITransactionDAO1 tdao1;
	
	@Autowired
	ITransactionDAO2 tdao2;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
//	@Transactional(propagation = Propagation.REQUIRED) // 관련 작업 모두 취소
	@Transactional(propagation = Propagation.REQUIRES_NEW) // 현재 작업은 독립 실행
	@Override
	public int buy(String id, int amount, String error) {
		try {
			transactionTemplate.execute(
				new TransactionCallbackWithoutResult() {
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus status) {
						tdao1.pay(id, amount);
						
						if (error.equals("1")) {
							int n = 10 / 0; // 의도적으로 강제 에러 발생
						} 
						
						tdao2.pay(id, amount);
						System.out.println("### Transaction #1 Commit");
					}
				}
			);
			return 1;
		} catch (Exception e) {
			System.out.println("### Transaction #1 Rollback");
			return 2;
		}
	}

}
