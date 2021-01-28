package com.juno.bg08;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert(
			@ModelAttribute("c")
			@Valid
			Content c
			, BindingResult result) {
		String page = "createDonePage";
		
		if (result.hasErrors()) { // 어느 멤버변수인지 모르지만, 에러내용이 존재한다면
			if (result.getFieldError("writer") != null) { // writer 멤버변수에 대한 에러내용이 존재한다면
				System.out.println("1: " + result.getFieldError("writer").getDefaultMessage());
			}
			if (result.getFieldError("content") != null) { // writer 멤버변수에 대한 에러내용이 존재한다면
				System.out.println("2: " + result.getFieldError("content").getDefaultMessage());
			}
			page = "createPage";
		}
		
		return page;
	}
}
