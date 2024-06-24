package org.o7planning.comicvn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.o7planning.comicmvc.bean.LSDocTruyenBean;

public class LSDocTruyenDao {
	public ArrayList<LSDocTruyenBean> getLS(String un)throws Exception{
		ArrayList<LSDocTruyenBean>ds=new ArrayList<LSDocTruyenBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql = "SELECT * FROM VLSDocTruyen WHERE Username=? ORDER BY NgayDoc DESC";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, un);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maTruyen=rs.getString("MaTruyen");
			String username=rs.getString("Username");
			String tenTruyen=rs.getString("TenTruyen");
			String ngayDoc=null;
			if(rs.getDate("NgayDoc")!=null) {
			Date tam = new java.util.Date(rs.getDate("NgayDoc").getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			ngayDoc = formatter.format(tam);
			}
			String avatar=rs.getString("Avatar");
			ds.add(new LSDocTruyenBean(maTruyen, username, tenTruyen, ngayDoc, avatar));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
