package com.juno.bg14.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juno.bg13.valid.ContentValidator;
import com.juno.bg14.dto.Board;
import com.juno.bg14.dto.Member;
import com.juno.bg14.dto.Reply;
import com.juno.bg14.service.BoardService;
import com.juno.bg14.util.Paging;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("b") Board b, BindingResult result
			, Model model
			, HttpServletRequest request
			) {
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			MultipartRequest multi = new MultipartRequest(
					request
					, path
					, 1024 * 1024 * 10
					, "UTF-8"
					, new DefaultFileRenamePolicy()
			);
			b.setUserid(multi.getParameter("userid"));
			b.setPass(multi.getParameter("pass"));
			b.setEmail(multi.getParameter("email"));
			b.setTitle(multi.getParameter("title"));
			b.setContent(multi.getParameter("content"));
			String file = multi.getFilesystemName("filename");
			if (file == null) {
				file = "";
			}
			b.setImage(file);
			
			ContentValidator validator = new ContentValidator();
			validator.validate(b, result);
			
			if (result.hasErrors()) {
				if (result.getFieldError("pass") != null)
					model.addAttribute("message", "pass");
				if (result.getFieldError("email") != null)
					model.addAttribute("message", "email");
				if (result.getFieldError("title") != null)
					model.addAttribute("message", "title");
				if (result.getFieldError("content") != null)
					model.addAttribute("message", "content");
				return "board/boardWriteForm";
			}
		} catch (IOException e) {e.printStackTrace();}
		
		bs.insertBoard(b);
		return "redirect:/main";
	}
	

	@RequestMapping(value = "/boardWriteForm")
	public String boardWriteForm(Model model, HttpServletRequest request) {
		if ((Member) request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		}
		return "board/boardWriteForm";
	}

	@RequestMapping(value = "/boardDelete")
	public String boardDelete(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			) {
		bs.removeBoard(num);
		return "redirect:/main";
	}

	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Model model, HttpServletRequest request
			, @ModelAttribute("b") Board b
			, BindingResult result
		) {
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			MultipartRequest multi = new MultipartRequest(
					request
					, path
					, 1024 * 1024 * 10
					, "UTF-8"
					, new DefaultFileRenamePolicy()
			);
			b.setNum(Integer.parseInt(multi.getParameter("num")));
			b.setUserid(multi.getParameter("userid"));
			b.setPass(multi.getParameter("pass"));
			b.setEmail(multi.getParameter("email"));
			b.setTitle(multi.getParameter("title"));
			b.setContent(multi.getParameter("content"));
			String file = multi.getFilesystemName("filename");
			String oldimage = multi.getParameter("oldimage");
			if (file != null) {
				b.setImage(file);
			} else if (oldimage != null) {
				b.setImage(oldimage);
			} else {
				b.setImage(null);
			}
			
			ContentValidator validator = new ContentValidator();
			validator.validate(b, result);
			
			if (result.hasErrors()) {
				if (result.getFieldError("pass") != null)
					model.addAttribute("message", "pass");
				if (result.getFieldError("email") != null)
					model.addAttribute("message", "email");
				if (result.getFieldError("title") != null)
					model.addAttribute("message", "title");
				if (result.getFieldError("content") != null)
					model.addAttribute("message", "content");
				
				return "board/boardUpdateForm";
			}
		} catch (IOException e) {e.printStackTrace();}
		
		bs.updateBoard(b);
		return "redirect:/boardViewAfterReply?num=" + b.getNum();
	}

	@RequestMapping(value = "/boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			) {
		model.addAttribute("b", bs.getBoard(num));
		return "board/boardUpdateForm";
	}
	
	@RequestMapping("/boardEdit")
	public String boardEdit(Model model, HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		
		Board b = bs.getBoard(num);
		model.addAttribute("num", num);
		
		if (pass.equals(b.getPass())) {
			return "board/boardCheckPass";
		} else {
			model.addAttribute("message", "비밀번호가 맞지않습니다. 확인해주세요");
			return "board/boardCheckPassForm";
		}
	}

	@RequestMapping(value = "/boardDeleteForm", method = RequestMethod.GET)
	public String boardDeleteForm(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			) {
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}

	@RequestMapping(value = "/boardEditForm", method = RequestMethod.GET)
	public String boardEditForm(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			) {
		model.addAttribute("num", num);
		return "board/boardCheckPassForm";
	}

	@RequestMapping(value = "/deleteReply")
	public String deleteReply(Model model, HttpServletRequest request
			, @RequestParam("num") int num
			, @RequestParam("boardnum") int boardnum
			) {

		if (request.getSession().getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			bs.deleteReply(num);
			return "redirect:/boardViewAfterReply?num="+boardnum;	
		}
	}

	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public String addReply(@ModelAttribute("r") @Valid Reply r, BindingResult result, Model model) {
		if (result.getFieldError("content") != null) {
			model.addAttribute("message", "내용을 입력하세요");
			return "redirect:/boardViewAfterReply?num="+r.getBoardnum();
		}
		bs.insertReply(r);
		return "redirect:/boardViewAfterReply?num="+r.getBoardnum();
	}

	@RequestMapping(value = "/boardView")
	public String boardView(Model model, HttpServletRequest request
			, @RequestParam("num") int num) {
		model.addAttribute("b", bs.readBoard(num));
		model.addAttribute("replyList", bs.selectReply(num));
		return "board/boardView";
	}
	
	@RequestMapping(value = "boardViewAfterReply")
	public String boardViewAfterReply(@RequestParam("num") int num, Model model, HttpServletRequest request) {
		model.addAttribute("b", bs.getBoard(num));
		model.addAttribute("replyList", bs.selectReply(num));
		return "board/boardView";
	}
	
	@RequestMapping("memberJoinForm")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "loginForm";
	}
	
	@RequestMapping("/main")
	public String goMain(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginUser") == null) {
			return "loginForm";
		} else {
			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(bs.getAllCount());
			paging.calc();

			model.addAttribute("boardList", bs.getAll(paging));
			model.addAttribute("paging", paging);
		}
		
		return "main";
	}
}
