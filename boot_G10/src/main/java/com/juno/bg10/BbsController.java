package com.juno.bg10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BbsController {
	
	@Autowired
	BbsDao bdao;
	
	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("list", bdao.list());
		return "list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm(Model model) {
		return "writeForm";
	}
	
	@RequestMapping("write")
	public String write(Bbs b, Model model) {
		bdao.write(b);
		return "redirect:/";
	}
	
	@RequestMapping("view")
	public String view(Model model, @RequestParam("id") String id) {
		model.addAttribute("b", bdao.view(id));
		return "view";
	}
	
	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id") String id) {
		bdao.delete(id);
		return "redirect:/";
	}

}
