package org.o7planning.comicmvc.bo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicvn.dao.TruyenDao;

public class TruyenBo {
	ArrayList<TruyenBean>ds;
	TruyenDao trdao=new TruyenDao();
	public ArrayList<TruyenBean>getDsTruyen(String xnn, String matl, int sotrang, int soPhanTrang)throws Exception{
		ds=trdao.getDsTruyen(xnn,matl,sotrang,soPhanTrang);
		Calendar c=Calendar.getInstance();
		int ngay=c.get(Calendar.DAY_OF_MONTH);
		int thang=c.get(Calendar.MONTH);
		int nam=c.get(Calendar.YEAR);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		for(TruyenBean i:ds) {
			System.out.println(i.getNgayDangMoi());
			
			if(i.getNgayDangMoi()!=null) {
				Date date = formatter.parse(i.getNgayDangMoi());
				c.setTime(date);
				if((c.get(Calendar.YEAR)==nam)&&(c.get(Calendar.MONTH)==thang)&&(ngay- c.get(Calendar.DAY_OF_MONTH)<=7)) {
//					System.out.println(ngay- c.get(Calendar.DAY_OF_MONTH));
					if(ngay- c.get(Calendar.DAY_OF_MONTH)==0) {
						i.setNgayDangMoi("Hôm nay");
					}
					else {
						int ndm=ngay- c.get(Calendar.DAY_OF_MONTH);
						i.setNgayDangMoi(String.valueOf(ndm)+" ngày trước");
					}
				}
			}
		}
		return ds;
	}
	public ArrayList<TruyenBean> getDsTruyen(String key){
		ArrayList<TruyenBean> dstim=new ArrayList<TruyenBean>();
		for(TruyenBean truyen:ds) {
			if(truyen.getTenTruyen()!=null)
				if(truyen.getTenTruyen().toLowerCase().contains(key.toLowerCase()))
						dstim.add(truyen);
				
		}
		return dstim;
	}
	public TruyenBean getTruyenTheoMa(String matr)throws Exception{
		return trdao.getTruyenTheoMa(matr);
	}
	public int getTongSoTrang(String matl, int soPhanTrang) throws Exception{
		int tongSoTruyen =  trdao.getTongSoTruyen( matl);
		int tongSoTrang;
		if(tongSoTruyen%soPhanTrang!=0) {
			tongSoTrang=tongSoTruyen/soPhanTrang+1;
		}
		else
			tongSoTrang=tongSoTruyen/soPhanTrang;
		return tongSoTrang;
	}
	public int updateTruyen(String maTruyen,String tenTruyen, String tacGia, String avatar, String gioiThieu) throws Exception{
		if(avatar==null) {
			avatar=trdao.getTruyenTheoMa(maTruyen).getAvatar();
		}
		else {
			avatar="img/"+avatar;
		}
		return trdao.updateTruyen(maTruyen, tenTruyen, tacGia, avatar, gioiThieu);
	}
	public int themTruyen(String tenTruyen, String tacGia, String avatar, String gioiThieu)throws Exception{
		if(avatar!=null) {
			avatar="img/"+avatar;
		}
		String maSach="T"+Integer.toString(trdao.getTongSoTruyen(null)+1) ;
		return trdao.themTruyen(maSach, tenTruyen, tacGia, avatar, gioiThieu);
	}
	public int  updateLuotLike(String maTruyen,String luot) throws Exception{
		return trdao.updateLuotLike(maTruyen, Integer.parseInt(luot));
	}
}
