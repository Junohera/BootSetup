package com.juno.bm01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bm01.dto.Cart;
import com.juno.bm01.dto.Member;
import com.juno.bm01.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cs;
	
	@RequestMapping(value = "/cartDelete", method = RequestMethod.POST)
    public String cartDelete(Model model, @RequestParam("cseq") String[] cseqArr) {
        for (String cseq: cseqArr) {
            cs.deleteCart(cseq);
        }
        
        return "redirect:/cartList";
    }

    @RequestMapping(value = "/cartInsert", method = RequestMethod.POST)
    public String cartInsert(Model model, HttpServletRequest request, @RequestParam("pseq") int pseq, @RequestParam("quantity") int quantity) {
        HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("loginUser");
        if (m == null) {
            return "member/login";
        } else {
            Cart c = new Cart();
            c.setId(m.getId());
            c.setPseq(pseq);
            c.setQuantity(quantity);
            cs.insertCart(c);
        }

        return "redirect:/cartList";
    }
    
    @RequestMapping(value = "/cartList", method = RequestMethod.GET)
    public String cartList(Model model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("loginUser");
        if (m == null) {
            return "member/login";
        } else {
            List<Cart> list = cs.listCart(m.getId());
            int totalPrice = 0;
            for (Cart c : list) {
            	totalPrice += c.getPrice2() * c.getQuantity();
            }
            
            model.addAttribute("cartList", list);
            model.addAttribute("totalPrice", totalPrice);
        }
        
        return "mypage/cartList";
    }
}
