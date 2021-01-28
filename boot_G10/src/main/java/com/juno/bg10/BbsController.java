package com.juno.bg10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
	
	@Autowired
	BbsDao bdao;
	
	@RequestMapping("/")
	public String root(Model model) {
		List<Bbs> list = bdao.list();
		model.addAttribute("list", list);
		return "list";
	}
}
