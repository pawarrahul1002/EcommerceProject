package com.jdbcDemo.secondDemo.ProductsManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDBConnection {
	
	public static Connection con;

	public static Connection ConnectproductDB()throws Exception
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver Loaded");
			
			//creating the connection
			String id = "root";
			String pass = "root";
			String url =  "jdbc:mysql://localhost:3306/productdb"; //database name
			con = DriverManager.getConnection(url,id,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
