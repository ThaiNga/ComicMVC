package org.o7planning.comicvn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.o7planning.comicmvc.bean.ChapTruyenBean;


public class ChapTruyenDao {
	public ArrayList<ChapTruyenBean>GetDsChapTruyen(String matr)throws Exception{
		ArrayList<ChapTruyenBean>ds=new ArrayList<ChapTruyenBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT * FROM ChapTruyen WHERE MaTruyen = ? ORDER BY MaChap DESC" ;
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, matr);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			int maChap=rs.getInt("MaChap");
			String tenChap=rs.getString("TenChap");
			Date tam = new java.util.Date(rs.getDate("NgayDang").getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String ngayDang = formatter.format(tam);
			long luotXem=rs.getLong("LuotXem");
			ds.add(new ChapTruyenBean(maChap, tenChap, ngayDang, luotXem));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int GetMaChap(String matr, String chuyenchap)throws Exception{
		int machap=0;String str="";
		if(chuyenchap.equals("dtd")) {
			str="min";
		}
		else {
			str="max";
		}
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT "+str+"(MaChap) as mamoi from ChapTruyen where MaTruyen = ?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, matr);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			machap=rs.getInt("mamoi");
		}
		rs.close();
		kn.cn.close();
		return machap;
	}
	public String GetMaTruyen(int machap)throws Exception{
		String matr="";
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT MaTruyen FROM ChapTruyen WHERE MaChap = ?" ;
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, machap);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			matr=rs.getString("MaTruyen");
		}
		rs.close();
		kn.cn.close();
		return matr;
	}
	public String GetTenChap(int machap)throws Exception{
		String tenchap="";
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT TenChap FROM ChapTruyen WHERE MaChap = ?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, machap);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			tenchap=rs.getString("TenChap");
		}
		rs.close();
		kn.cn.close();
		return tenchap;
	}
	public int themChapTruyen(String maTruyen,String tenChap,java.sql.Date ngayDang)throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="INSERT INTO ChapTruyen(MaTruyen,TenChap,NgayDang,LuotXem) VALUES(?,?,?,0)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1,maTruyen );
		cmd.setString(2, tenChap);
		cmd.setDate(3, ngayDang);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public int getMaChap() throws Exception{
		int tong=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="select max(MaChap) as MaChap from ChapTruyen";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		rs.next();
		tong=rs.getInt("MaChap");
		rs.close();
		kn.cn.close();
		return tong;
	}
	public int updateLuotXem(int maChap) throws Exception {
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="UPDATE ChapTruyen SET LuotXem=LuotXem+1 WHERE MaChap=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, maChap);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
}
