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

import com.juno.bg13.dto.Member;
import com.juno.bg13.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("m") @Valid Member m, BindingResult result, Model model, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			if (result.getFieldError("id") != null) {
				model.addAttribute("message", "아이디를 입력하세요");
				return "loginForm";
			} else if (result.getFieldError("pw") != null) {
				model.addAttribute("message", result.getFieldError("pw").getDefaultMessage());
				return "loginForm";
			}
		}
		
		Member findM = ms.getMember(m.getId());
		
		if (findM == null) {
			model.addAttribute("message", "아이디가 없습니다");
			return "loginForm";
		} else if (findM.getPw() == null) {
			model.addAttribute("message", "회원정보 오류입니다. 관리자에게 문의하세요.");
			return "loginForm";
		} else if (!findM.getPw().equals(m.getPw())) {
			model.addAttribute("message", "비밀번호가 맞지않습니다.");
			return "loginForm";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", findM);
			return "redirect:/main";
		}
	}
	
	@RequestMapping("/")
	public String index() {
		return "loginForm";
	}
}
