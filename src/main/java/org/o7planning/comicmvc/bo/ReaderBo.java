package org.o7planning.comicmvc.bo;

import java.sql.Date;
import java.util.ArrayList;

import org.o7planning.comicmvc.bean.ReaderBean;
import org.o7planning.comicvn.dao.ReaderDao;

public class ReaderBo {
	ReaderDao rddao=new ReaderDao();
	public int DangKy(String username,String matkhau,String email) throws Exception{
		return rddao.DangKy(username, matkhau, email);
	}
	public ReaderBean ktDangNhap(String un, String matkhau) throws Exception{
		return rddao.ktDangNhap(un, matkhau);
	}
	public boolean ktDangKy(String username,String email) throws Exception{
		return rddao.ktDangKy(username, email);
	}
	public int themTruyenReader(String maTruyen, String maUser)throws Exception{
		long millis=System.currentTimeMillis(); 
		 java.sql.Date date = new java.sql.Date(millis);
		return rddao.themTruyenReader(maTruyen, maUser,date);
	}
	public String getMaUser(String un) throws Exception{
		return rddao.getMaUser(un);
	}
	public boolean ktThemTruyenReader(String maTruyen, String maUser) throws Exception{
		return rddao.ktThemTruyenReader(maTruyen, maUser);
	}
	public boolean ktThichTruyen(String maTruyen, String maUser) throws Exception{
		return rddao.ktThichTruyen(maTruyen, maUser);
	}
	public int updateLuotLike(String maTruyen, String maUser, String luot) throws Exception{
		int thich = 1;
		if(luot.equals("-1")) {
			thich=0;
		}
		return rddao.updateLuotLike(maTruyen, maUser, thich);
	}
	public int updateNgayDoc(String maTruyen, String maUser) throws Exception{
		long millis=System.currentTimeMillis(); 
		 java.sql.Date date = new java.sql.Date(millis);
		 return rddao.updateNgayDoc(maTruyen, maUser, date);
	}
	public boolean ktAdmin(String maUser) throws Exception{
		return rddao.ktAdmin(maUser);
	}
}
