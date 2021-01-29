package com.juno.bg13.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.bg13.service.BoardService;
import com.juno.bg13.util.Paging;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public String goMain(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(bs.getAllCount());
			paging.calc();

			model.addAttribute("boardList", bs.getAll(paging));
			model.addAttribute("paging", paging);
		}
		
		return "main";
	}
}
