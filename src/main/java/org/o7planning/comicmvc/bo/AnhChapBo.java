package org.o7planning.comicmvc.bo;

import java.util.ArrayList;

import org.o7planning.comicmvc.bean.AnhChapBean;
import org.o7planning.comicvn.dao.AnhChapDao;

public class AnhChapBo {
	ArrayList<AnhChapBean>ds;
	AnhChapDao acdao=new AnhChapDao();
	public ArrayList<AnhChapBean> GetDsAnhChap(int machap) throws Exception{
		ds=acdao.GetDsAnhChap(machap);
		return ds;
	}
	public int themAnhChap(int maChap,String fileAnh)throws Exception{
		fileAnh="img/"+fileAnh;
		return acdao.themAnhChap(maChap, fileAnh);
	}
}
