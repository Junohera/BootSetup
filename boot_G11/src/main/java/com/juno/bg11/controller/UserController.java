package com.juno.bg11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.bg11.dao.IUserDao;

@Controller
public class UserController {
	
	@Autowired
	IUserDao udao;
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("users", udao.list());
		return "userList";
	}
}
