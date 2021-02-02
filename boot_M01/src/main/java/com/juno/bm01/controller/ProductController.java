package com.juno.bm01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juno.bm01.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("newProductList", ps.getNewList());
		model.addAttribute("bestProductList", ps.getBestList());
		return "index";
	}
}