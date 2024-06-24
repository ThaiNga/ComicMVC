package org.o7planning.comicmvc.bo;

import java.util.ArrayList;

import org.o7planning.comicmvc.bean.LSDocTruyenBean;
import org.o7planning.comicvn.dao.LSDocTruyenDao;

public class LSDocTruyenBo {
	LSDocTruyenDao lsdao=new LSDocTruyenDao();
	ArrayList<LSDocTruyenBean>ds;
	public ArrayList<LSDocTruyenBean> getLS(String un)throws Exception{
		ds=lsdao.getLS(un);
		return ds;
	}
}
