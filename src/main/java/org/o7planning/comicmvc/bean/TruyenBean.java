package org.o7planning.comicmvc.bean;

import java.util.Date;

public class TruyenBean {
	private String MaTruyen;
	private String TenTruyen;
	private String TacGia;
	private String Avatar;
	private int LuotLike;
	private String GioiThieu;
	private int MaChapMoi;
	private String TenChapMoi;
	private String NgayDangMoi;
	private long TongLuotXem;
	public TruyenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TruyenBean(String maTruyen, String tenTruyen, String tacGia, String avatar, int luotLike, String gioiThieu,
			int maChapMoi, String tenChapMoi, String ngayDangMoi, long tongLuotXem) {
		super();
		MaTruyen = maTruyen;
		TenTruyen = tenTruyen;
		TacGia = tacGia;
		Avatar = avatar;
		LuotLike = luotLike;
		GioiThieu = gioiThieu;
		MaChapMoi = maChapMoi;
		TenChapMoi = tenChapMoi;
		NgayDangMoi = ngayDangMoi;
		TongLuotXem = tongLuotXem;
	}
	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		MaTruyen = maTruyen;
	}
	public String getTenTruyen() {
		return TenTruyen;
	}
	public void setTenTruyen(String tenTruyen) {
		TenTruyen = tenTruyen;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public int getLuotLike() {
		return LuotLike;
	}
	public void setLuotLike(int luotLike) {
		LuotLike = luotLike;
	}
	public String getGioiThieu() {
		return GioiThieu;
	}
	public void setGioiThieu(String gioiThieu) {
		GioiThieu = gioiThieu;
	}
	public int getMaChapMoi() {
		return MaChapMoi;
	}
	public void setMaChapMoi(int maChapMoi) {
		MaChapMoi = maChapMoi;
	}
	public String getTenChapMoi() {
		return TenChapMoi;
	}
	public void setTenChapMoi(String tenChapMoi) {
		TenChapMoi = tenChapMoi;
	}
	public String getNgayDangMoi() {
		return NgayDangMoi;
	}
	public void setNgayDangMoi(String ngayDangMoi) {
		NgayDangMoi = ngayDangMoi;
	}
	public long getTongLuotXem() {
		return TongLuotXem;
	}
	public void setTongLuotXem(long tongLuotXem) {
		TongLuotXem = tongLuotXem;
	}
	
}
