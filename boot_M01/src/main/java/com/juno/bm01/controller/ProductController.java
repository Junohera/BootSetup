package com.juno.bm01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/category")
    public String category(Model model, @RequestParam("kind") String kind) {
        model.addAttribute("productKindList", ps.getKindList(kind));
        return "product/productKind";
    }

	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetail(Model model, HttpServletRequest request, @RequestParam("pseq") int pseq) {
        model.addAttribute("p", ps.getProduct(pseq));
        return "product/productDetail";
    }
}