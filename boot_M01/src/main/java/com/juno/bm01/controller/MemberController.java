package com.juno.bm01.controller;

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

import com.juno.bm01.dto.Member;
import com.juno.bm01.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request
		, @ModelAttribute("rm") @Valid Member rm
		, BindingResult result
	) {
		if (result.getFieldError("id") != null) {
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
			return "member/login";
		} else if (result.getFieldError("pwd") != null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/login";
		}
		
        Member m = ms.getMember(rm.getId());

        if (m != null) {
        	if (m.getPwd() != null) {
        		if (m.getPwd().equals(rm.getPwd())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loginUser", m);
                    return "redirect:/";
                } else model.addAttribute("message", "no match password");	
        	} else model.addAttribute("message", "invalid user info, call admin");
        } else model.addAttribute("message", "no id");

        return "member/login";
    }
}
