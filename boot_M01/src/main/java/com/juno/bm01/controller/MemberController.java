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
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contract(Model model, HttpServletRequest request) {
		return "member/contract";
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return "redirect:/";
	}

	@RequestMapping(value = "/joinForm")
	public String joinForm(Model model, HttpServletRequest request) {
		return "member/joinForm";
	}

	@RequestMapping(value = "/idCheckForm")
    public String idCheckForm(Model model, HttpServletRequest request
		, @RequestParam("id") String id
	) {
        Member m = ms.getMember(id);
        int result = 0;
        if (m == null) result = -1;
        else result = 1;
        
        model.addAttribute("result", result);
        model.addAttribute("id", id);
        return "member/idCheck";
    }
	
	@RequestMapping(value = "/findZipNum")
    public String findZipNum(Model model, HttpServletRequest request) {
		String dong = request.getParameter("dong");
        if (dong != null && !dong.trim().equals("")) {
            model.addAttribute("addressList", ms.selectAddressByDong(dong));
        }
        return "member/findZipNum";
    }
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, HttpServletRequest request
			, @ModelAttribute("m") @Valid Member m
			, BindingResult result
			) {
		if (result.getFieldError("id") != null) {
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
			return "member/joinForm";
		} else if (result.getFieldError("pwd") != null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/joinForm";
		} else if (result.getFieldError("name") != null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/joinForm";
		} else if (result.getFieldError("email") != null) {
			model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
			return "member/joinForm";
		} else if (!request.getParameter("reid").equals(m.getId())) {
			model.addAttribute("message", "ID 중복체크 누락");
			return "member/joinForm";
		} else if (!request.getParameter("pwdCheck").equals(m.getPwd())) {
			model.addAttribute("message", "PWD check");
			return "member/joinForm";
		}

		m.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		ms.insertMember(m);
		
		return "redirect:loginForm";
	}
	
	@RequestMapping(value = "/memberEditForm", method = RequestMethod.GET)
    public String memberEditForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member m = (Member) session.getAttribute("loginUser");

        String addr = m.getAddress();
        try {
        	int k1 = addr.indexOf(" ");
            int k2 = addr.indexOf(" ", k1+1);
            int k3 = addr.indexOf(" ", k2+1);

            String addr1 = addr.substring(0, k3);
            String addr2 = addr.substring(k3+1);
            
            model.addAttribute("addr1", addr1);
            model.addAttribute("addr2", addr2);
        } catch(Exception e) {
        	model.addAttribute("addr1", "");
            model.addAttribute("addr2", "");
        }

        model.addAttribute("m", m);
        

        return "member/editForm";
    }

	@RequestMapping(value = "updateMember", method = RequestMethod.POST)
	public String update(Model model, HttpServletRequest request
			, @ModelAttribute("m") @Valid Member m
			, BindingResult result
			) {

		model.addAttribute("addr1", request.getParameter("addr1"));
		model.addAttribute("addr2", request.getParameter("addr2"));

		if (result.getFieldError("pwd") != null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/editForm";
		} else if (result.getFieldError("name") != null) {
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
			return "member/editForm";
		} else if (result.getFieldError("email") != null) {
			model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
			return "member/editForm";
		} else if (!request.getParameter("pwdCheck").equals(m.getPwd())) {
			model.addAttribute("message", "PWD check");
			return "member/editForm";
		}

		m.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		ms.updateMember(m);
		request.getSession().setAttribute("loginUser", m);
		return "redirect:/";
	}
}
