package org.o7planning.comicmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DangXuatController {
	@RequestMapping("/dangxuat")
	public ModelAndView DangXuat(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		session.removeAttribute("un");
		session.removeAttribute("admin");
		try {
			response.sendRedirect("home");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
