package com.juno.bg05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LombokController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Lombok 사용하기";
	}
	
	@RequestMapping("/test1")
	public String test1(Member m, Model model) {
		System.out.println(m.getId() + " " + m.getName());
		return "test1";
	}
}
