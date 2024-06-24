package org.o7planning.comicmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.comicmvc.bo.ReaderBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import nl.captcha.Captcha;

@Controller
public class DangKyController {
	@RequestMapping("/dangky")
	public ModelAndView DangKy(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String un=request.getParameter("txtun");
			String email=request.getParameter("txtemail");
			String pass=request.getParameter("txtpass");
			String repass=request.getParameter("txtrepass");
			String dk=request.getParameter("dk");
			if(dk!=null) {
//				HttpSession session=request.getSession();
//				Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
//				request.setCharacterEncoding("UTF-8");
//				String answer = request.getParameter("answer");
//				if(answer==null)
//					model.addAttribute("thongbao","Điền thiếu captcha");
//				else if (captcha.isCorrect(answer)) {
				if(pass.equals(repass)) {
					ReaderBo rdbo=new ReaderBo();
					if(un==null||email==null||pass==null){
						model.addAttribute("kt","Điền thiếu thông tin!");
					}
					else if(rdbo.ktDangKy(un, email)) {
						rdbo.DangKy(un, pass, email);
						model.addAttribute("kt","Đã đăng kí thành công");
					}
					else {
					model.addAttribute("kt","Tài Khoản đã có người đăng kí!");
					}
				}
				else {
						model.addAttribute("kt","Mật khẩu không đồng nhất");
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("dangky");
	}
}
