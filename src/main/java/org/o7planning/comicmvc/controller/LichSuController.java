package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.comicmvc.bean.LSDocTruyenBean;
import org.o7planning.comicmvc.bo.LSDocTruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LichSuController {
	@RequestMapping("/lichsu")
	public ModelAndView Home(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		try {
			LSDocTruyenBo lsbo=new LSDocTruyenBo();
			String username=session.getAttribute("un").toString();
			ArrayList<LSDocTruyenBean>ds=lsbo.getLS(username);
			model.addAttribute("ds",ds);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("lichsu");
			
		
	}
}
