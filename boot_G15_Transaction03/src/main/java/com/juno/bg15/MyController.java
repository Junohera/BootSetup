package com.juno.bg15;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bg15.dao.ITransactionDAO3;
import com.juno.bg15.service.IBuyTicketService;

@Controller
public class MyController {
	
	@Autowired
	IBuyTicketService bs;
	
	@Autowired
	ITransactionDAO3 tdao3;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "buy_ticket";
	}
	
	@RequestMapping("/buyTicketCard")
	public String buy_ticket_card(Model model, HttpServletRequest request
			, @RequestParam("id") String id
			, @RequestParam("amount") int amount
			, @RequestParam("error") String error
	) {
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		
		try {
			transactionTemplate.execute(
				new TransactionCallbackWithoutResult() {
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus status) {
						int nResult = bs.buy(id, amount, error);
						
						if (error.equals("2")) {
							int n = 10 / 0; // 강제 에러발생
						}
						
						tdao3.pay(id, amount);
						System.out.println("### Transaction #2 Commit");
					}
				}
			);
			return "buy_ticket_end";
		} catch (Exception e) {
			System.out.println("### Transaction #2 Rollback");
			return "buy_ticket_error";
		}
	}

}
