package org.o7planning.comicmvc.bean;

public class TheLoaiBean {
	private String MaTheLoai;
	private String TenTheLoai;
	public TheLoaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheLoaiBean(String maTheLoai, String tenTheLoai) {
		super();
		MaTheLoai = maTheLoai;
		TenTheLoai = tenTheLoai;
	}
	public String getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	
}
