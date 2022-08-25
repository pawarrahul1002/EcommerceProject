package com.jdbcDemo.firstDemo;
import  java.sql.Connection;
import java.sql.DriverManager;



public class ConnectStudentDatabase {
	
	static Connection conn;
	
	
	public static Connection CreateConnection()
	{
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

		    //System.out.println("Driver loaded!"); //use to confirm driver loading
			
			//create the connections
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/studentdata";
			conn = DriverManager.getConnection(url,user,password);
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return conn;
		
	}
}


























