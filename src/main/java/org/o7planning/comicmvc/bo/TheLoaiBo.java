package org.o7planning.comicmvc.bo;

import java.util.ArrayList;

import org.o7planning.comicmvc.bean.TheLoaiBean;
import org.o7planning.comicvn.dao.TheLoaiDao;

public class TheLoaiBo {
	ArrayList<TheLoaiBean>ds;
	TheLoaiDao tldao=new TheLoaiDao();
	public ArrayList<TheLoaiBean> getDsTL()throws Exception{
		ds = tldao.GetDsTL();
		return ds;
	}
	public String getTenTL(String matl) {
		String tentl = null;
		for(TheLoaiBean theloai:ds) {
			if(theloai.getMaTheLoai().equals(matl)) {
				tentl=theloai.getTenTheLoai();
			}
		}
		return tentl;
	}
	public ArrayList<TheLoaiBean>GetDsTLTruyen(String matr)throws Exception{
		return tldao.GetDsTLTruyen(matr);
	}
}
