package org.o7planning.comicmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.o7planning.comicmvc.bean.TheLoaiBean;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.TheLoaiBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChinhSuaController {
	@RequestMapping("/chinhsua")
	public ModelAndView ChinhSua(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			String matr=request.getParameter("matr");
			if(matr!=null&&matr!="") {
				TruyenBo trbo=new TruyenBo();
				TruyenBean truyen=trbo.getTruyenTheoMa(matr);
				model.addAttribute("truyen",truyen);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("chinhsua");
	}
	@RequestMapping("/chinhsuatam")
	public ModelAndView Home(Model model, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			TruyenBo trbo=new TruyenBo();
			String name=null;String tacgia=null;String gioithieu=null;String avatar=null;
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
//						              System.out.println("UPLOAD THÀNH CÔNG...!");
//						              System.out.println("Đường dẫn lưu file là: "+dirUrl);
						              avatar=nameimg;
						 } catch (Exception e) {
						    e.printStackTrace();
						}
					}
				 }
					else//Neu la control
					{
						String tentruyen=fileItem.getFieldName();
						if(tentruyen.equals("txtname"))
							name=fileItem.getString("UTF-8");
//					System.out.println("Tên truyện là:"+fileItem.getString());
// response.getWriter().println(fileItem.getString("UTF-8"));
						if(tentruyen.equals("txttacgia"))
							tacgia=fileItem.getString("UTF-8");
//					System.out.println("Tên tác giả là:"+fileItem.getString());
						if(tentruyen.equals("txtgioithieu"))
							gioithieu=fileItem.getString("UTF-8");
//					System.out.println("Giới thiệu là:"+fileItem.getString());
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			if(matr!=null&&matr!="") {
				trbo.updateTruyen(matr, name, tacgia, avatar, gioithieu);
				model.addAttribute("thongbao","Chỉnh sửa truyện thành công");
			}
			else {
				trbo.themTruyen(name, tacgia, avatar, gioithieu);
				model.addAttribute("thongbao","Thêm truyện thành công");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ModelAndView("chinhsua");
	}
}
