package com.juno.bg15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.juno.bg15.dao.ITransactionDAO1;
import com.juno.bg15.dao.ITransactionDAO2;

@Service
public class BuyTicketService implements IBuyTicketService {
	
	@Autowired
	ITransactionDAO1 tdao1;
	
	@Autowired
	ITransactionDAO2 tdao2;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition definition;

	@Override
	public int buy(String id, int amount, String error) {
		
		// Transaction의 시작 - 끝은 return
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			tdao1.pay(id, amount);
			
			if (error.equals("1")) {
				int n = 10 / 0; // 의도적으로 강제 에러 발생
			} 
			
			tdao2.pay(id, amount);
			
			// tdao1.pay와 tdao2.pay 둘다 실행한 시점에 commit
			transactionManager.commit(status);
			System.out.println("### Transaction Commit");
			return 1;
		} catch (Exception e) {
			
			// tdao1.pay와 tdao2.pay 실행하는 시점에 오류가 나서 catch로 왔다면 전부 rollback
			transactionManager.rollback(status);
			System.out.println("### Transaction Rollback");
			return 2;
		}
	}

}
