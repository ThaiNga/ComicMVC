package org.o7planning.comicvn.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.o7planning.comicmvc.bean.ReaderBean;

public class ReaderDao {
	MaHoa mahoa = new MaHoa();
	public int GetSoNguoi()throws Exception{
		int songuoi=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT COUNT(MaUser) AS SoNguoi FROM Reader";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			songuoi=rs.getInt("SoNguoi");
		}
		rs.close();
		kn.cn.close();
		return songuoi;
	}
	public int DangKy(String username,String matkhau,String email) throws Exception {
		int songuoi=GetSoNguoi()+1;
		String mauser="R"+Integer.toString(songuoi);
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="INSERT INTO Reader(MaUser,Username,MatKhau,Email) VALUES(?,?,?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, mauser);
		cmd.setString(2, username);
		cmd.setString(3, mahoa.ecrypt(matkhau));
		cmd.setString(4, email);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public ReaderBean ktDangNhap(String un, String matkhau) throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM Reader WHERE (Username=? OR Email=?) AND MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, un);
		cmd.setString(2, un);
		cmd.setString(3, MaHoa.ecrypt(matkhau));
		ResultSet rs = cmd.executeQuery();
		
		ReaderBean user = null;
		if(rs.next()) {
			String maUser=rs.getString("MaUser");
			String username=rs.getString("Username");
			String matKhau=rs.getString("MatKhau");
			String email=rs.getString("Email"); 
			user=new ReaderBean(maUser, username, matKhau, email);
		}
		kn.cn.close();
		cmd.close();
		return user;
	}
	public boolean ktDangKy(String username,String email) throws Exception{
		int dem=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT COUNT(MaUser) AS SoNguoi FROM Reader WHERE Username=? OR Email=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, email);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			dem=rs.getInt("SoNguoi");
		}
		rs.close();
		kn.cn.close();
		if(dem!=0)
			return false;
		else
			return true;
	}
	public int themTruyenReader(String maTruyen, String maUser, Date ngayDoc)throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="INSERT INTO Truyen_Reader(MaTruyen,MaUser,Thich, NgayDoc)VALUES(?,?,0,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, maTruyen);
		cmd.setString(2, maUser);
		cmd.setDate(3, ngayDoc);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public String getMaUser(String un) throws Exception{
		String ma=null;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT MaUser FROM Reader WHERE Username=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, un);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		ma=rs.getString("MaUser");
		kn.cn.close();
		cmd.close();
		return ma;
	}
	public boolean ktThemTruyenReader(String maTruyen, String maUser) throws Exception{
		int dem=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Count(*) as SoNguoi FROM Truyen_Reader WHERE MaTruyen=? AND MaUser=? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maTruyen);
		cmd.setString(2, maUser);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			dem=rs.getInt("SoNguoi");
		}
		rs.close();
		kn.cn.close();
		if(dem!=0)
			return false;
		else
			return true;
	}
	public boolean ktThichTruyen(String maTruyen, String maUser) throws Exception{
		int dem=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Thich FROM Truyen_Reader WHERE MaTruyen=? AND MaUser=? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maTruyen);
		cmd.setString(2, maUser);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		dem=rs.getInt("Thich");
		rs.close();
		kn.cn.close();
		if(dem==1)
			return true;
		return false;
	}
	public int updateLuotLike(String maTruyen, String maUser, int thich) throws Exception {
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="UPDATE Truyen_Reader SET Thich=? WHERE MaTruyen=? AND MaUser=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, thich);
		cmd.setString(2, maTruyen);
		cmd.setString(3, maUser);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public int updateNgayDoc(String maTruyen, String maUser, Date ngayDoc) throws Exception {
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="UPDATE Truyen_Reader SET NgayDoc=? WHERE MaTruyen=? AND MaUser=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setDate(1, ngayDoc);
		cmd.setString(2, maTruyen);
		cmd.setString(3, maUser);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public boolean ktAdmin(String maUser) throws Exception{
		int dem=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT Admin FROM Reader WHERE MaUser=? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maUser);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		dem=rs.getInt("Admin");
		rs.close();
		kn.cn.close();
		if(dem==1) {
			return true;
		}
		return false;
	}
}
