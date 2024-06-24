package org.o7planning.comicvn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.comicmvc.bean.AnhChapBean;

public class AnhChapDao {
	public ArrayList<AnhChapBean> GetDsAnhChap(int machap) throws Exception{
		ArrayList<AnhChapBean>ds=new ArrayList<AnhChapBean>();
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="SELECT * FROM     AnhChap WHERE  MaChap = ?";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1, machap);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			int maAnh=rs.getInt("MaAnh");
			String fileAnh=rs.getString("FileAnh");
			ds.add(new AnhChapBean(maAnh, fileAnh));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int themAnhChap(int maChap,String fileAnh)throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketnoi();
		String sql="INSERT INTO AnhChap(MaChap,FileAnh) VALUES(?,?)";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		cmd.setInt(1,maChap );
		cmd.setString(2, fileAnh);
		int kq=cmd.executeUpdate();
		kn.cn.close();
		cmd.close();
		return kq;
	}
}
