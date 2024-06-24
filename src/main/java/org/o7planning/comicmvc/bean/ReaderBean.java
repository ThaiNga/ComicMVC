package org.o7planning.comicmvc.bean;

public class ReaderBean {
	private String MaUser;
	private String Username;
	private String MatKhau;
	private	String Email;
	public ReaderBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReaderBean(String maUser, String username, String matKhau, String email) {
		super();
		MaUser = maUser;
		Username = username;
		MatKhau = matKhau;
		Email = email;
	}
	public String getMaUser() {
		return MaUser;
	}
	public void setMaUser(String maUser) {
		MaUser = maUser;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
