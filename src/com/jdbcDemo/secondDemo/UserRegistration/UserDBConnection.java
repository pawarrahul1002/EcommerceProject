package com.jdbcDemo.secondDemo.UserRegistration;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDBConnection {

	public static Connection con;
	
	public static Connection createUserDbConn() {
		
		try {
			//load the  driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loaded");
			
			//Create the connection
			String user = "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/user_datadb";
			
			con = DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
