package org.o7planning.comicvn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
	public Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da nap");
		String url="jdbc:sqlserver://localhost:1433;databaseName=Comic;user=sa;password=123;encrypt=false;trustServerCertificate=true";
		cn=DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}
