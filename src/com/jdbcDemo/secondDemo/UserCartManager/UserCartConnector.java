package com.jdbcDemo.secondDemo.UserCartManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class UserCartConnector {
	
	public static Connection con;

	public static Connection connectCartDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String userId = "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/user_datadb";
			con  = DriverManager.getConnection(url,userId,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
