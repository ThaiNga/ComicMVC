package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.comicmvc.bean.AnhChapBean;
import org.o7planning.comicmvc.bean.ChapTruyenBean;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.AnhChapBo;
import org.o7planning.comicmvc.bo.ChapTruyenBo;
import org.o7planning.comicmvc.bo.ReaderBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReadController {
	@RequestMapping("/read")
	public ModelAndView Read(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			String strmachap=request.getParameter("machap");
			String chuyentruoc=request.getParameter("chuyentruoc");
			String chuyentiep=request.getParameter("chuyentiep");
			ChapTruyenBo ctbo=new ChapTruyenBo();
			int machap=Integer.parseInt(strmachap);
			ctbo.updateLuotXem(machap);
			String matr=ctbo.GetMaTruyen(machap);
			ArrayList<ChapTruyenBean>dschap=ctbo.GetDsChapTruyen(matr);
			model.addAttribute("dschap",dschap);
			if(chuyentruoc!=null&&chuyentruoc!="") {
				machap=ctbo.getChapTruoc(machap);
			}
			if(chuyentiep!=null&&chuyentiep!="") {
				machap=ctbo.getChapTiep(machap);
			}
			
			model.addAttribute("machap",machap);
			model.addAttribute("tenchap",ctbo.GetTenChap(machap));
			
			AnhChapBo acbo=new AnhChapBo();
			ArrayList<AnhChapBean>dsanh=acbo.GetDsAnhChap(machap);
			model.addAttribute("dsanh",dsanh);
			
			TruyenBo trbo=new TruyenBo();
			TruyenBean truyen=trbo.getTruyenTheoMa(matr);
			model.addAttribute("truyen",truyen);
			
			
			int chapdau=ctbo.GetMaChap(matr, "dtd");
			model.addAttribute("chapdau",chapdau);
			int chapmoi=ctbo.GetMaChap(matr, "cmn");
			model.addAttribute("chapmoi",chapmoi);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("truyenread");
	}
}
