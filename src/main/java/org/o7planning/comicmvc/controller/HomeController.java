package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.comicmvc.bean.TheLoaiBean;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.TheLoaiBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView Home(Model model, HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/home")
	public ModelAndView TrangChu(Model model, HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String xnn = request.getParameter("xnn");
			String key=request.getParameter("txttk");
			String matl=request.getParameter("matl");
			String sotrangtam=request.getParameter("sotrang");
			int sotrang=1;
			if(sotrangtam!=null) {
				sotrang=Integer.parseInt(sotrangtam);
			}
			model.addAttribute("sotrang",sotrang);
			model.addAttribute("key",key);
			model.addAttribute("matl",matl);
			
			TruyenBo trbo=new TruyenBo();
			ArrayList<TruyenBean>ds=trbo.getDsTruyen(xnn,matl,sotrang,15);
			if(key!=null&&key!="") {
				ds=trbo.getDsTruyen(key);
			}
			model.addAttribute("ds",ds);
			int tongsotrang=trbo.getTongSoTrang( matl, 15);
			
			model.addAttribute("tongsotrang",tongsotrang);
			
			TheLoaiBo tlbo=new TheLoaiBo();
			ArrayList<TheLoaiBean>dstl=tlbo.getDsTL();
			if(matl!=null&&matl!="") {
				String tentl=tlbo.getTenTL(matl);
				model.addAttribute("tentl",tentl);
			}
			
			model.addAttribute("dstl", dstl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("menu");
	}
}
