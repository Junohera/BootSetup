package com.juno.bg15;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bg15.service.IBuyTicketService;

@Controller
public class MyController {
	
	@Autowired
	IBuyTicketService bs;
	
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
		int nResult = bs.buy(id, amount, error);
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);

		if (nResult == 1) {
			return "buy_ticket_end";
		}
		else {
			return "buy_ticket_error";
		}
	}

}
