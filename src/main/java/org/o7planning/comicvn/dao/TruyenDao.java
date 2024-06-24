package org.o7planning.comicvn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.o7planning.comicmvc.bean.TruyenBean;

public class TruyenDao {
	public ArrayList<TruyenBean> getDsTruyen(String xnn, String matl, int sotrang, int soPhanTrang) throws Exception{
		ArrayList<TruyenBean>ds=new ArrayList<TruyenBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="select * from Truyen";
		if(matl!=null&&matl!="") {
			String noitl=" INNER JOIN TheLoai_Truyen  ON TheLoai_Truyen.MaTruyen = Truyen.MaTruyen  WHERE  TheLoai_Truyen.MaTheLoai = ?";
			sql=sql+noitl;
		}
//		if(key!=null) {
//			String dk=" WHERE TacGia like '%?%' OR TenTruyen like '%?%'";
//			sql=sql+dk;
//		}
		String sort=" ORDER BY NgayDangMoi DESC";
		if(xnn!=null) {
			sort=" ORDER BY TongLuotXem DESC";
		}
		String phantrang=", Truyen.MaTruyen OFFSET ?*?-? ROWS FETCH NEXT ? ROWS ONLY";
		sql=sql+sort+phantrang;
		
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int i=1;
		if(matl!=null&&matl!="") {
			cmd.setString(i, matl);
			i++;
		}
//		if(key!=null) {
//			cmd.setString(i, key);
//			cmd.setString(i+1, key);
//			i+=2;
//		}
		cmd.setInt(i, sotrang);
		cmd.setInt(i+1, soPhanTrang);
		cmd.setInt(i+2, soPhanTrang);
		cmd.setInt(i+3, soPhanTrang);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maTruyen=rs.getString("MaTruyen");
			String tenTruyen=rs.getString("TenTruyen");
			String tacGia=rs.getString("TacGia");
			String avatar=rs.getString("Avatar");
			int luotLike=rs.getInt("LuotLike");
			String gioiThieu=rs.getString("GioiThieu");
			int maChapMoi=rs.getInt("MaChapMoi");
			String tenChapMoi=rs.getString("TenChapMoi");
			String ngayDangMoi = null;
			if(rs.getDate("NgayDangMoi")!=null) {
				Date tam = new java.util.Date(rs.getDate("NgayDangMoi").getTime());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				ngayDangMoi = formatter.format(tam);
			} 
			long tongLuotXem = rs.getLong("TongLuotXem");
			ds.add(new TruyenBean(maTruyen, tenTruyen, tacGia, avatar, luotLike, gioiThieu, maChapMoi, tenChapMoi, ngayDangMoi, tongLuotXem));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public TruyenBean getTruyenTheoMa(String matr)throws Exception{
		TruyenBean truyen=null;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="select * from Truyen WHERE MaTruyen = ?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, matr);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String maTruyen=rs.getString("MaTruyen");
			String tenTruyen=rs.getString("TenTruyen");
			String tacGia=rs.getString("TacGia");
			String avatar=rs.getString("Avatar");
			int luotLike=rs.getInt("LuotLike");
			String gioiThieu=rs.getString("GioiThieu");
			int maChapMoi=rs.getInt("MaChapMoi");
			String tenChapMoi=rs.getString("TenChapMoi");
			String ngayDangMoi = null;
			if(rs.getDate("NgayDangMoi")!=null) {
				Date tam = new java.util.Date(rs.getDate("NgayDangMoi").getTime());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				ngayDangMoi = formatter.format(tam);
			} 
			long tongLuotXem = rs.getLong("TongLuotXem");
			truyen=new TruyenBean(maTruyen, tenTruyen, tacGia, avatar, luotLike, gioiThieu, maChapMoi, tenChapMoi, ngayDangMoi, tongLuotXem);
		}
		rs.close();
		kn.cn.close();
		return truyen;
	}
	public int getTongSoTruyen( String matl) throws Exception{
		int tong=0;
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="select COUNT(Truyen.MaTruyen) as TongSoTruyen from Truyen";
		if(matl!=null&&matl!="") {
			String noitl=" INNER JOIN TheLoai_Truyen  ON TheLoai_Truyen.MaTruyen = Truyen.MaTruyen  WHERE  TheLoai_Truyen.MaTheLoai = ?";
			sql=sql+noitl;
		}
//		if(key!=null) {
//			String dk=" WHERE TacGia like N'%"+key+"%' OR TenTruyen like N'%"+key+"%'";
//			sql=sql+dk;
//		}
//		String sort=" ORDER BY NgayDangMoi DESC";
//		if(xnn!=null) {
//			sort=" ORDER BY TongLuotXem DESC";
//		}
//		sql=sql+sort;
		
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		int i=1;
		if(matl!=null&&matl!="") {
			cmd.setString(i, matl);
			i++;
		}
		ResultSet rs=cmd.executeQuery();
		rs.next();
		tong=rs.getInt("TongSoTruyen");
		rs.close();
		kn.cn.close();
		return tong;
	}
	public int updateTruyen(String maTruyen,String tenTruyen, String tacGia, String avatar, String gioiThieu) throws Exception {
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="UPDATE Truyen SET TenTruyen=?,TacGia=?, Avatar=?, GioiThieu=? WHERE MaTruyen=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, tenTruyen);
		cmd.setString(2, tacGia);
		cmd.setString(3, avatar);
		cmd.setString(4, gioiThieu);
		cmd.setString(5, maTruyen);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public int themTruyen(String maSach, String tenTruyen, String tacGia, String avatar, String gioiThieu)throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="INSERT INTO Truyen(MaTruyen,TenTruyen,TacGia,Avatar,LuotLike,GioiThieu)VALUES(?,?,?,?,0,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setString(1, maSach);
		cmd.setString(2, tenTruyen);
		cmd.setString(3, tacGia);
		cmd.setString(4, avatar);
		cmd.setString(5, gioiThieu);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
	public int updateLuotLike(String maTruyen,int luot) throws Exception {
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="UPDATE Truyen SET LuotLike=LuotLike + ? WHERE MaTruyen=?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, luot);
		cmd.setString(2, maTruyen);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
}
