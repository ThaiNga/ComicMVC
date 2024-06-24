package org.o7planning.comicmvc.bean;

public class ChapTruyenBean {
	private int MaChap;
	private String TenChap;
	private String NgayDang;
	private long LuotXem;
	public ChapTruyenBean(int maChap, String tenChap, String ngayDang, long luotXem) {
		super();
		MaChap = maChap;
		TenChap = tenChap;
		NgayDang = ngayDang;
		LuotXem = luotXem;
	}
	public ChapTruyenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaChap() {
		return MaChap;
	}
	public void setMaChap(int maChap) {
		MaChap = maChap;
	}
	public String getTenChap() {
		return TenChap;
	}
	public void setTenChap(String tenChap) {
		TenChap = tenChap;
	}
	public String getNgayDang() {
		return NgayDang;
	}
	public void setNgayDang(String ngayDang) {
		NgayDang = ngayDang;
	}
	public long getLuotXem() {
		return LuotXem;
	}
	public void setLuotXem(long luotXem) {
		LuotXem = luotXem;
	}
	
	
}
