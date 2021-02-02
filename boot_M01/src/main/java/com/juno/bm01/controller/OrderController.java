package com.juno.bm01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.bm01.dto.Cart;
import com.juno.bm01.dto.Member;
import com.juno.bm01.dto.Order;
import com.juno.bm01.service.CartService;
import com.juno.bm01.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@Autowired
	CartService cs;

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public ModelAndView orderDetail(Model model, HttpServletRequest request, @RequestParam("oseq") int oseq) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			List<Order> orderList = os.listOrderById(m.getId(), "%", oseq);
			int totalPrice = 0;
			for (Order o : orderList) totalPrice += o.getPrice2() * o.getQuantity();

			mv.addObject("orderDetail", orderList.get(0));
			mv.addObject("orderList", orderList);
			mv.addObject("totalPrice", totalPrice);
			mv.setViewName("mypage/orderDetail");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/orderAll", method = RequestMethod.GET)
	public ModelAndView orderAll(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			mv.addObject("title", "총 주문내역");
			mv.addObject("orderList", os.orderAll(m.getId()));
			mv.setViewName("mypage/mypage");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView mypage(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			mv.addObject("title", "진행중인 주문내역");
			mv.addObject("orderList", os.orderIng(m.getId()));
			mv.setViewName("mypage/mypage");
		}
		
		return mv;
	}

	/*
	@RequestMapping("immediatelyBuy")
	public String immediatelyBuy(Model model, HttpServletRequest request, @RequestParam("pseq") int pseq, @RequestParam("quantity") int quantity) {
		Member m = (Member) request.getSession().getAttribute("loginUser");
		int oseq = 0;
		if (m == null) {
			return "member/login";
		}
		else {
			oseq = os.insertOrders(pseq, quantity, m.getId());
		}
		return "redirect:/orderList?oseq=" + oseq;
	}
	*/
	
	@RequestMapping("orderInsert")
	public String orderInsert(Model model, HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginUser");
		int oseq = 0;
		if (m == null) {
			return "member/login";
		}
		else {
			List<Cart> cartList = cs.listCart(m.getId());
			oseq = os.insertOrders(cartList, m.getId());
		}
		return "redirect:/orderList?oseq=" + oseq;
	}
	
	@RequestMapping("orderList")
	public String orderList(Model model, HttpServletRequest request, @RequestParam("oseq") int oseq) {
		Member m = (Member) request.getSession().getAttribute("loginUser");
		
		if (m == null) {
			return "member/login";
		}
		else {
			List<Order> list = os.listOrderById(m.getId(), "1", oseq);
			int totalPrice = 0;
			for (Order o: list) {
				totalPrice += o.getPrice2() * o.getQuantity();
			}
			
			model.addAttribute("orderList", list);
			model.addAttribute("totalPrice", totalPrice);
		}
		
		return "mypage/orderList";
	}
}
