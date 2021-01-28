package com.juno.bg12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.bg12.dao.IBbsDao;

@Controller
public class BbsController {
	
	@Autowired
	IBbsDao bdao;
	
	@RequestMapping("/")
	public String userListPage(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
}
