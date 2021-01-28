package com.juno.bg09;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String userListPage(Model model) {
		List<User> list = null;
		
		model.addAttribute("users", list);
		return "userList";
	}
}
