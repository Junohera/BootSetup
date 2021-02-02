package com.juno.bm01.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juno.bm01.dto.Member;
import com.juno.bm01.dto.Order;
import com.juno.bm01.dto.Paging;
import com.juno.bm01.dto.Product;
import com.juno.bm01.dto.Qna;
import com.juno.bm01.service.AdminService;
import com.juno.bm01.service.ProductService;
import com.juno.bm01.service.QnaService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class AdminController {
	
	@Autowired
    AdminService as;
    
    @Autowired
    ProductService ps;

    @Autowired
    QnaService qs;

    @Autowired
    ServletContext ctx;

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin/adminLoginForm";
    }

    @RequestMapping(value = "/adminLogout")
    public ModelAndView adminLogout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/admin");
        return mv;
    }

    @RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public ModelAndView adminLogin(Model model, HttpServletRequest request
            , @RequestParam("workId") String workId
            , @RequestParam("workPwd") String workPwd
            ) {
        ModelAndView mv = new ModelAndView();

        int result = as.workerCheck(workId, workPwd);
        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("workId", workId);
            mv.setViewName("redirect:/adminProductList");
        } else if (result == 0) {
            mv.addObject("message", "비밀번호를 확인하세요");
            mv.setViewName("admin/adminLoginForm");
        } else if (result == -1) {
            mv.addObject("message", "아이디를 확인하세요");
            mv.setViewName("admin/adminLoginForm");
        }

        return mv;
    }

    @RequestMapping(value = "adminProductList")
    public ModelAndView productList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }
            
            String tableName = "PRODUCT";
            String searchType = "NAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt(tableName, searchType, key);
			paging.setTotalCount(totalCount);
			paging.calc();

            ArrayList<Product> productList = as.selectProduct(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("productList", productList);
            mv.setViewName("admin/product/productList");
        }
            
        return mv;
    }

    @RequestMapping(value = "/adminOrderList")
    public ModelAndView orderList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "MNAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("ORDER_VIEW", searchType, key);
			paging.setTotalCount(totalCount);
			paging.calc();

            ArrayList<Order> orderList = as.selectOrder(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("orderList",orderList);
            mv.setViewName("admin/order/orderList");
        }

        return mv;
    }

    @RequestMapping(value = "/adminMemberList")
    public ModelAndView memberList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "NAME";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("MEMBER", searchType, key);
			paging.setTotalCount(totalCount);
			paging.calc();

            ArrayList<Member> memberList = as.selectMember(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("memberList",memberList);
            mv.setViewName("admin/member/memberList");
        }
        
        return mv;
    }

    @RequestMapping(value = "/adminQnaList")
    public ModelAndView qnaList(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String workId = (String) session.getAttribute("workId");
        if (workId == null) {
            mv.setViewName("redirect:/admin");
        } else {
            if (request.getParameter("first") != null) {
                session.removeAttribute("key");
                session.removeAttribute("page");
            }

            String key = "";
            if (request.getParameter("key") != null) {
                key = request.getParameter("key");
                session.setAttribute("key", key);
            } else if (session.getAttribute("key") != null) {
                key = (String) session.getAttribute("key");
            } else {
                session.removeAttribute("key");
            }

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                session.setAttribute("page", page);
            } else if (session.getAttribute("page") != null) {
                page = (int) session.getAttribute("page");
            } else {
                session.removeAttribute("page");
            }

            String searchType = "SUBJECT";

            Paging paging = new Paging();
			paging.setPage(page);
			int totalCount = as.selectTotalCnt("QNA", searchType, key);
			paging.setTotalCount(totalCount);
			paging.calc();

            ArrayList<Qna> qnaList = as.selectQna(paging, searchType, key);

            mv.addObject("paging", paging);
            mv.addObject("key", key);
            mv.addObject("qnaList", qnaList);
            mv.setViewName("admin/qna/qnaList");
        }
        
        return mv;
    }

    @RequestMapping(value = "adminProductWriteForm")
    public ModelAndView adminProductWriteForm(Model model, HttpServletRequest request) {
        String kindList[] = {"Heels", "Boots", "Sandals", "Sneakers", "Slipers", "Sale"};
        ModelAndView mv = new ModelAndView();
        mv.addObject("kindList",kindList);
        mv.setViewName("admin/product/productWrite");

        return mv;
    }

    @RequestMapping(value = "productWrite")
    public String productWrite(Model model, HttpServletRequest request) {
        String savePath = ctx.getRealPath("../include/product_images");

        try {
            MultipartRequest multi = new MultipartRequest(
                request
                , savePath
                , 5 * 1024 * 1024
                , "UTF-8"
                , new DefaultFileRenamePolicy()
            );

            Product p = new Product();
            p.setKind(multi.getParameter("kind"));
            p.setName(multi.getParameter("name"));
            p.setPrice1(Integer.parseInt(multi.getParameter("price1")));
            p.setPrice2(Integer.parseInt(multi.getParameter("price2")));
            p.setPrice3(p.getPrice2() - p.getPrice1());
            p.setContent(multi.getParameter("content"));
            p.setImage(multi.getFilesystemName("image"));

            as.insertProduct(p);
        } catch (IOException e) {e.printStackTrace();}
        
        return "redirect:/adminProductList";
    }

    @RequestMapping(value = "adminProductDetail")
    public ModelAndView adminProductDetail(Model model, HttpServletRequest request
            , @RequestParam("pseq") int pseq
            ) {
        ModelAndView mv = new ModelAndView();
        Product p = ps.getProduct(pseq);
        String kindList[] = {"Heels", "Boots", "Sandals", "Sneakers", "Slipers", "Sale"};
        mv.addObject("kind", kindList[Integer.parseInt(p.getKind()) - 1]);
        mv.addObject("p", p);
        mv.setViewName("admin/product/productDetail");
        return mv;
    }

    @RequestMapping(value = "adminProductUpdateForm")
    public ModelAndView productUpdateForm(Model model, HttpServletRequest request
            , @RequestParam("pseq") int pseq
            ) {
        ModelAndView mv = new ModelAndView();
        Product p = ps.getProduct(pseq);
        String kindList[] = {"Heels", "Boots", "Sandals", "Sneakers", "Slipers", "Sale"};
        mv.addObject("kindList", kindList);
        System.out.println(p.getKind());
        mv.addObject("p", p);
        mv.setViewName("admin/product/productUpdate");
        return mv;
    }

    @RequestMapping(value = "adminProductUpdate")
    public ModelAndView adminProductUpdate(Model model, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
    
        String uploadFilePath = ctx.getRealPath("../include/product_images");
        MultipartRequest multi;
		try {
			multi = new MultipartRequest(
			    request,
			    uploadFilePath,
			    5 * 1024 * 1024,
			    "UTF-8",
			    new DefaultFileRenamePolicy()
			);
			
			Product p = new Product();
	        p.setPseq(Integer.parseInt(multi.getParameter("pseq")));
	        p.setKind(multi.getParameter("kind"));
	        p.setName(multi.getParameter("name"));
	        p.setPrice1(Integer.parseInt(multi.getParameter("price1")));
	        p.setPrice2(Integer.parseInt(multi.getParameter("price2")));
	        p.setPrice3(Integer.parseInt(multi.getParameter("price3")));
	        p.setContent(multi.getParameter("content"));
	        p.setUseyn(multi.getParameter("useyn"));
	        p.setBestyn(multi.getParameter("bestyn"));
	        if (multi.getFilesystemName("image") == null) {
	            p.setImage(multi.getParameter("nonmakeImg"));
	        } else {
	            p.setImage(multi.getFilesystemName("image"));
	        }
	        
	        as.updateProduct(p);
	        mv.addObject("pseq", p.getPseq());
	        mv.setViewName("redirect:/adminProductDetail");
	        
		} catch (IOException e) {e.printStackTrace();}
        
        return mv;
    }

    @RequestMapping(value = "adminOrderSave")
    public String adminOrderSave(Model model, HttpServletRequest request) {
        String[] resultArr = request.getParameterValues("result");
			
        for (String odseq : resultArr) {
            as.updateOrderResult(Integer.parseInt(odseq));
        }
        return "redirect:/adminOrderList";
    }
    
    @RequestMapping(value = "adminQnaDetail")
    public ModelAndView adminQnaDetail(Model model, HttpServletRequest request
            , @RequestParam("qseq") int qseq
            ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("q", qs.getQna(qseq));
        mv.setViewName("admin/qna/qnaDetail");
        return mv;
    }

    @RequestMapping(value = "adminQnaAttachAnswer")
    public ModelAndView adminQnaAttachAnswer(Model model, HttpServletRequest request
            , @RequestParam("qseq") int qseq
            , @RequestParam("reply") String reply
        ) {
        ModelAndView mv = new ModelAndView();
        Qna q = new Qna();
        q.setQseq(qseq);
        q.setReply(reply);
        as.qnaAttachAnswer(q);
        mv.addObject("q", q);
        mv.addObject("qseq", qseq);
        mv.setViewName("redirect:/adminQnaDetail");
        return mv;
    }
}
