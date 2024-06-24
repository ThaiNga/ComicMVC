package org.o7planning.comicmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.comicmvc.bo.ReaderBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DangNhapController {
	@RequestMapping("/dangnhap")
	public ModelAndView DangNhap(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			String un=request.getParameter("txtun");
			String mk=request.getParameter("txtmk");
			String dangnhap=request.getParameter("dangnhap");
			ReaderBo rdbo=new ReaderBo();
			if(dangnhap!=null) {
				if(un==null||mk==null) {
					model.addAttribute("thongbao","Nhập thiếu thông tin");
				}
				else if(rdbo.ktDangNhap(un, mk)==null){
					model.addAttribute("thongbao","Đăng nhập không chính xác!");
				}
				else {
					session.setAttribute("un", rdbo.ktDangNhap(un, mk).getUsername());
					if(rdbo.ktAdmin(rdbo.ktDangNhap(un, mk).getMaUser())) {
						session.setAttribute("admin", rdbo.ktDangNhap(un, mk).getUsername());
					}
					response.sendRedirect("home");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("dangnhap");
	}
}
