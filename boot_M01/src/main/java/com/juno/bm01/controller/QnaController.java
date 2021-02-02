package com.juno.bm01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.bm01.dto.Member;
import com.juno.bm01.dto.Qna;
import com.juno.bm01.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	QnaService qs;

	@RequestMapping(value = "/qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(Model model, HttpServletRequest request
			, @ModelAttribute("q") @Valid Qna q
			, BindingResult result 
			) {
		ModelAndView mv = new ModelAndView();
		
		if (result.getFieldError("subject") != null) {
			model.addAttribute("message", "제목을 입력하세요");
			mv.setViewName("qna/qnaWrite");
		} else if (result.getFieldError("content") != null) {
			model.addAttribute("message", "내용을 입력하세요");
			mv.setViewName("qna/qnaWrite");
		}
		
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			q.setId(m.getId());
			qs.insertQna(q);
			mv.setViewName("redirect:/qnaList");
		}
		
		return mv;
	}

	@RequestMapping(value = "qnaWriteForm", method = RequestMethod.GET)
	public String qnaWriteForm(Model model, HttpServletRequest request) {
		if ((Member) request.getSession().getAttribute("loginUser") == null) {
			return "member/login";
		}
		else {
			return "qna/qnaWriteForm";	
		}
	}

	@RequestMapping(value = "/qnaView", method = RequestMethod.GET)
	public ModelAndView qnaView(Model model, HttpServletRequest request
			, @RequestParam("qseq") int qseq) {
		ModelAndView mv = new ModelAndView();
		
		Member m = (Member) request.getSession().getAttribute("loginUser");
		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			mv.addObject("q", qs.getQna(qseq));
			mv.setViewName("qna/qnaView");	
		}
		
		return mv;
	}

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Member m = (Member) request.getSession().getAttribute("loginUser");

		if (m == null) {
			mv.setViewName("member/login");
		}
		else {
			List<Qna> qnaList = qs.listQna(m.getId());
			mv.addObject("qnaList", qnaList);
			mv.setViewName("qna/qnaList");
		}
		
		return mv;
	}
}
