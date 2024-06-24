package org.o7planning.comicmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.AnhChapBo;
import org.o7planning.comicmvc.bo.ChapTruyenBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThemChapController {
	@RequestMapping("/themchap")
	public ModelAndView ThemChap(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			String matr=request.getParameter("matr");
			model.addAttribute("matr",matr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("themchap");
	}
	@RequestMapping("/themchapchinh")
	public ModelAndView ThemChapChinh(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			AnhChapBo acbo=new AnhChapBo();
			ChapTruyenBo ctbo=new ChapTruyenBo();
			String tenChap=null;
			String matr=request.getParameter("matr");
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "files";
		 response.getWriter().println(dirUrl1);
		 
		try {
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			//duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
				// xử lý file
				String nameimg = fileItem.getName();
				if (!nameimg.equals("")) {
			           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
					String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "img";
					File dir = new File(dirUrl);
					if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
						dir.mkdir();
					}
				           String fileImg = dirUrl + File.separator + nameimg;
				           File file = new File(fileImg);//tạo file
				            try {
				               fileItem.write(file);//lưu file
//				              System.out.println("UPLOAD THÀNH CÔNG...!");
//				              System.out.println("Đường dẫn lưu file là: "+dirUrl);
				              acbo.themAnhChap(ctbo.getMaChap(), nameimg);
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
		 }
			else//Neu la control
			{
				String tenchap=fileItem.getFieldName();
				if(tenchap.equals("txtname")) {
					tenChap=fileItem.getString("UTF-8");
					ctbo.themChapTruyen(matr, tenChap);
					model.addAttribute("thongbao","Thêm chap thành công");
				}
					

			}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		model.addAttribute("matr",matr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ModelAndView("themchap");
	}
}
