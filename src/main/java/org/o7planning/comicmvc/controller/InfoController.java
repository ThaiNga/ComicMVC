package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.comicmvc.bean.ChapTruyenBean;
import org.o7planning.comicmvc.bean.TheLoaiBean;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.ChapTruyenBo;
import org.o7planning.comicmvc.bo.ReaderBo;
import org.o7planning.comicmvc.bo.TheLoaiBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	@RequestMapping("/info")
	public ModelAndView Info(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			TruyenBo trbo=new TruyenBo();
			String matr = request.getParameter("matr");
			String luot= request.getParameter("luot");
			if(session.getAttribute("un")!=null) {
				String username=session.getAttribute("un").toString();
				ReaderBo rdbo=new ReaderBo();
				if(rdbo.ktThemTruyenReader(matr, rdbo.getMaUser(username))) {
					rdbo.themTruyenReader(matr,rdbo.getMaUser(username));
				}
				else {
					rdbo.updateNgayDoc(matr, rdbo.getMaUser(username));
					if(luot!=null&&luot!="") {
					rdbo.updateLuotLike(matr, rdbo.getMaUser(username), luot);
					trbo.updateLuotLike(matr, luot);
					}
					
				}
				model.addAttribute("thich",false);//chưa thích
				if(rdbo.ktThichTruyen(matr, rdbo.getMaUser(username))) {
					model.addAttribute("thich",true);//đã thích
				}
				
			}
			
			TruyenBean truyen=trbo.getTruyenTheoMa(matr);
			model.addAttribute("truyen",truyen);
			ChapTruyenBo ctbo=new ChapTruyenBo();
			ArrayList<ChapTruyenBean>dschap=ctbo.GetDsChapTruyen(matr);
			model.addAttribute("dschap",dschap);
			TheLoaiBo tlbo=new TheLoaiBo();
			ArrayList<TheLoaiBean>dstl=tlbo.GetDsTLTruyen(matr);
			model.addAttribute("dstl",dstl);
			int chapdau=ctbo.GetMaChap(matr, "dtd");
			model.addAttribute("chapdau",chapdau);
			int chapmoi=ctbo.GetMaChap(matr, "cmn");
			model.addAttribute("chapmoi",chapmoi);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("truyeninfo");
	}
}
