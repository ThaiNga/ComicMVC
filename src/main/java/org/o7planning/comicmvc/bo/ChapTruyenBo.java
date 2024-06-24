package org.o7planning.comicmvc.bo;

import java.util.ArrayList;

import org.o7planning.comicmvc.bean.ChapTruyenBean;
import org.o7planning.comicvn.dao.ChapTruyenDao;

public class ChapTruyenBo {
	ArrayList<ChapTruyenBean>ds;
	ChapTruyenDao ctdao=new ChapTruyenDao();
	public ArrayList<ChapTruyenBean>GetDsChapTruyen(String matr)throws Exception{
		ds=ctdao.GetDsChapTruyen(matr);
		return ds;
	}
	public int GetMaChap(String matr, String chuyenchap)throws Exception{
		return ctdao.GetMaChap(matr, chuyenchap);
	}
	public String GetMaTruyen(int machap)throws Exception{
		return ctdao.GetMaTruyen(machap);
	}
	public String GetTenChap(int machap)throws Exception{
		return ctdao.GetTenChap(machap);
	}
	public int getChapTiep(int machap) {
		int mamoi=0;
		int n=ds.size()-1;
		for(int i=0;i<n;i++) {
			if(ds.get(i+1).getMaChap()==machap) {
				mamoi=ds.get(i).getMaChap();
				return mamoi;
			}
		}
		return mamoi;
	}
	public int getChapTruoc(int machap) {
		int mamoi=0;
		for(int i=ds.size()-1;i>0;i--) {
			if(ds.get(i-1).getMaChap()==machap) {
				mamoi=ds.get(i).getMaChap();
			}
		}
		return mamoi;
	}
	public int themChapTruyen(String maTruyen,String tenChap)throws Exception{
		long millis=System.currentTimeMillis(); 
		 java.sql.Date date = new java.sql.Date(millis);
		return ctdao.themChapTruyen(maTruyen, tenChap, date);
	}
	public int getMaChap() throws Exception{
		return ctdao.getMaChap();
	}
	public int updateLuotXem(int maChap) throws Exception {
		return ctdao.updateLuotXem(maChap);
	}
}
