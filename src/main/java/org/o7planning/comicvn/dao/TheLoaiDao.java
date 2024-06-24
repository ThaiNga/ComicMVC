package org.o7planning.comicvn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.comicmvc.bean.TheLoaiBean;

public class TheLoaiDao {
	public ArrayList<TheLoaiBean>GetDsTL() throws Exception{
		ArrayList<TheLoaiBean>ds=new ArrayList<TheLoaiBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT * FROM TheLoai";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maTheLoai=rs.getString("MaTheLoai");
			String tenTheLoai=rs.getString("TenTheLoai");
			ds.add(new TheLoaiBean(maTheLoai, tenTheLoai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<TheLoaiBean>GetDsTLTruyen(String matr)throws Exception{
		ArrayList<TheLoaiBean>ds=new ArrayList<TheLoaiBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT TheLoai.* FROM Truyen INNER JOIN TheLoai_Truyen ON Truyen.MaTruyen = TheLoai_Truyen.MaTruyen INNER JOIN TheLoai ON TheLoai_Truyen.MaTheLoai = TheLoai.MaTheLoai WHERE Truyen.MaTruyen = ?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, matr);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maTheLoai=rs.getString("MaTheLoai");
			String tenTheLoai=rs.getString("TenTheLoai");
			ds.add(new TheLoaiBean(maTheLoai, tenTheLoai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
