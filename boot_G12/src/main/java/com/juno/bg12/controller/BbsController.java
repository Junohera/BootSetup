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
	public String write(
		@ModelAttribute("b") @Valid Bbs b
		, BindingResult result
		, Model model) {
		
		if (result.hasErrors()) {
			if (result.getFieldError("writer") != null) model.addAttribute("msg", result.getFieldError("writer").getDefaultMessage());
			else if (result.getFieldError("title") != null) model.addAttribute("msg", result.getFieldError("title").getDefaultMessage());
			else if (result.getFieldError("content") != null) model.addAttribute("msg", result.getFieldError("content").getDefaultMessage());
			return "writeForm";
		} else {
			bdao.write(b);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
		@ModelAttribute("b") @Valid Bbs b
		, BindingResult result
		, Model model) {
		
		if (result.hasErrors()) {
			if (result.getFieldError("writer") != null) model.addAttribute("msg", result.getFieldError("writer").getDefaultMessage());
			else if (result.getFieldError("title") != null) model.addAttribute("msg", result.getFieldError("title").getDefaultMessage());
			else if (result.getFieldError("content") != null) model.addAttribute("msg", result.getFieldError("content").getDefaultMessage());
			return "updateForm";
		} else {
			bdao.update(b);
			return "redirect:/";
		}
	}
	
	@RequestMapping("view")
	public String view(Model model
			, @RequestParam("id") String id) {
		model.addAttribute("b", bdao.view(id));
		return "view";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id") String id) {
		bdao.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("b", bdao.view(id));
		return "updateForm";
	}
}
