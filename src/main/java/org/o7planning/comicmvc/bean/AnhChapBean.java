package org.o7planning.comicmvc.bean;

public class AnhChapBean {
	private int MaAnh;
	private String FileAnh;
	public AnhChapBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnhChapBean(int maAnh, String fileAnh) {
		super();
		MaAnh = maAnh;
		FileAnh = fileAnh;
	}
	public int getMaAnh() {
		return MaAnh;
	}
	public void setMaAnh(int maAnh) {
		MaAnh = maAnh;
	}
	public String getFileAnh() {
		return FileAnh;
	}
	public void setFileAnh(String fileAnh) {
		FileAnh = fileAnh;
	}
	
}
