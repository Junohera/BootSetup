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

import com.juno.bg13.dto.Member;
import com.juno.bg13.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;

	@RequestMapping(value = "/memberEdit", method = RequestMethod.POST)
	public String memberEdit(Model model, HttpServletRequest request
			, @ModelAttribute("m") @Valid Member m
			, BindingResult result
			, @RequestParam("pw_check") String pwchk
			) {

		if (result.getFieldError("pw") != null) {
			model.addAttribute("message", result.getFieldError("pw").getDefaultMessage());
			return "member/memberEditForm";
		} else if (result.getFieldError("name") != null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/memberEditForm";
		} else if (!m.getPw().equals(pwchk)) {
			model.addAttribute("message", "비밀번호 체크를 다시 해주세요.");
			return "member/memberEditForm";
		} else {
			ms.updateMember(m);
			request.getSession().setAttribute("loginUser", m);
			return "redirect:/main";
		}
	}

	@RequestMapping("/memberEditForm")
	public String memberEditForm(HttpServletRequest request) {
		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		}
		return "member/memberEditForm";
	}
	
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public String memJoin(
			@ModelAttribute("m") @Valid Member m
			, BindingResult result
			, @RequestParam("re_id") String reid
			, @RequestParam("pw_check") String pwchk
			, Model model, HttpServletRequest request) {
			
		if (result.getFieldError("id") != null) {
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
			return "member/memberJoinForm";
		} else if (result.getFieldError("pw") != null) {
			model.addAttribute("message", result.getFieldError("pw").getDefaultMessage());
			return "member/memberJoinForm";
		} else if (result.getFieldError("name") != null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/memberJoinForm";
		} else if (!m.getId().equals(reid)) {
			model.addAttribute("message", "아이디 중복검사를 다시 진행해주세요.");
			return "member/memberJoinForm";
		} else if (!m.getPw().equals(pwchk)) {
			model.addAttribute("message", "비밀번호 체크를 다시 해주세요.");
			return "member/memberJoinForm";
		} else {
			ms.insertMember(m.getId(), m.getPw(), m.getName(), m.getEmail(), m.getPhone1(), m.getPhone3(), m.getPhone3());
			model.addAttribute("message", "사용자가 추가되었습니다. 로그인 하세요");
			return "loginForm";
		}
	}
	
	@RequestMapping("idCheck")
	public String idCheck(@RequestParam("id") String id, Model model) {
		int result = ms.getMember(id) == null ? -1: 1;
		model.addAttribute("result", result);
		model.addAttribute("id", id);
		return "member/idCheck";
	}
	
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
