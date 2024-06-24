package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public ModelAndView Admin(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			TruyenBo trbo = new TruyenBo();
			String key = request.getParameter("txttk");
			String sotrangtam=request.getParameter("sotrang");
			int sotrang=1;
			if(sotrangtam!=null) {
				sotrang=Integer.parseInt(sotrangtam);
			}
			model.addAttribute("sotrang",sotrang);
			ArrayList<TruyenBean>ds=trbo.getDsTruyen(null, null, sotrang, 6);
			if(key!=null&&key!="") {
				ds=trbo.getDsTruyen(key);
			}
			model.addAttribute("key",key);
			model.addAttribute("ds",ds);
			int tongsotrang=trbo.getTongSoTrang( null, 6);
			
			model.addAttribute("tongsotrang",tongsotrang);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("admin");
	}
}
