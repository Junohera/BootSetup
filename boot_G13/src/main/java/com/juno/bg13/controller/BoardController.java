package com.juno.bg13.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bg13.dto.Reply;
import com.juno.bg13.service.BoardService;
import com.juno.bg13.util.Paging;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;

	@RequestMapping(value = "/deleteReply")
	public String deleteReply(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			, @RequestParam("boardnum") int boardnum
			) {

		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			bs.deleteReply(num);
			return "redirect:/boardView?num="+boardnum;	
		}
	}

	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public String addReply(@ModelAttribute("r") @Valid Reply r, BindingResult result, Model model) {
		if (result.getFieldError("content") != null) {
			model.addAttribute("message", "내용을 입력하세요");
			return "redirect:/boardView?num="+r.getBoardnum();
		}
		bs.insertReply(r);
		return "redirect:/boardView?num="+r.getBoardnum();
	}

	@RequestMapping(value = "/boardView")
	public String boardView(Model model, HttpServletRequest request
			, @RequestParam("num") int num) {
		model.addAttribute("b", bs.readBoard(num));
		model.addAttribute("replyList", bs.selectReply(num));
		return "board/boardView";
	}
	
	@RequestMapping("memberJoinForm")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "loginForm";
	}
	
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
