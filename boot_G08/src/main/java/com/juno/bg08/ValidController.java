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
		
		if (result.hasErrors()) {
			
		}
		
		return page;
	}
}
