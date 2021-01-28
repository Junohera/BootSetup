package com.juno.bg12.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bg12.dao.IBbsDao;
import com.juno.bg12.dto.Bbs;

@Controller
public class BbsController {
	
	@Autowired
	IBbsDao bdao;
	
	@RequestMapping("/")
	public String userListPage(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute("b") @Valid Bbs b, BindingResult result, Model model) {
		
		return "redirect:/view";
	}
	
	@RequestMapping("view")
	public String view(Model model
			, @RequestParam("id") String id) {
		model.addAttribute("b", bdao.view(id));
		return "view";
	}
}
