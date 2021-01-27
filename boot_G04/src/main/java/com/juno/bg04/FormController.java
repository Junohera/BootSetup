package com.juno.bg04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Form 데이터전달받아 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		model.addAttribute("id", id);
		model.addAttribute("name", name);

		return "test1";
	}
}
