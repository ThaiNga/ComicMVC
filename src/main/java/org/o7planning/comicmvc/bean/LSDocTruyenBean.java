package org.o7planning.comicmvc.bean;

public class LSDocTruyenBean {
	private String MaTruyen;
	private String Username;
	private String TenTruyen;
	private String NgayDoc;
	private String Avatar;
	public LSDocTruyenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LSDocTruyenBean(String maTruyen, String username, String tenTruyen, String ngayDoc, String avatar) {
		super();
		MaTruyen = maTruyen;
		Username = username;
		TenTruyen = tenTruyen;
		NgayDoc = ngayDoc;
		Avatar = avatar;
	}
	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		MaTruyen = maTruyen;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getTenTruyen() {
		return TenTruyen;
	}
	public void setTenTruyen(String tenTruyen) {
		TenTruyen = tenTruyen;
	}
	public String getNgayDoc() {
		return NgayDoc;
	}
	public void setNgayDoc(String ngayDoc) {
		NgayDoc = ngayDoc;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	
}
