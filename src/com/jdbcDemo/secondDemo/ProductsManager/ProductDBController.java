package com.jdbcDemo.secondDemo.ProductsManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ProductDBController {
	
	public static void main(String[] args) throws Exception
	{
//		showProductAscendingOrd();
//		System.out.println("");
//		showProductByAscendingPrice();
		
		showProductAscendingOrd("pName");
	}
	
	
	public static void showProductAscendingOrd(String str) throws Exception
	{
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
			System.out.println(con);
			
			String q = "SELECT * FROM productdata ORDER BY "+str +" DESC";
			
			Statement st = con.createStatement();
			ResultSet set =  st.executeQuery(q);
			
			
//			String q = "SELECT * FROM productdata ORDER BY ? DESC";
//			
//			PreparedStatement pstmt = con.prepareStatement(q);
//			pstmt.setString(1,"pID");
//			ResultSet set =  pstmt.executeQuery(q);		
			while(set.next())
			{
				int pID = set.getInt(1);
				String pName = set.getString(2);
				String pDesc = set.getString(3);
				int qty = set.getInt(4);
				int price = set.getInt(5);
				
				System.out.println ("ID = " + pID + 
							", Prod Name = " + pName + 
							", Prod Desc = " + pDesc + 
							", Quantity = " + qty + 
							", Price = " + price );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void showProductByAscendingPrice() throws Exception
	{
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
			System.out.println(con);
			
			String q = "SELECT * FROM productdata ORDER BY price ";
			Statement st = con.createStatement();
			ResultSet set =  st.executeQuery(q);
			
			while(set.next())
			{
				int pID = set.getInt(1);
				String pName = set.getString(2);
				String pDesc = set.getString(3);
				int qty = set.getInt(4);
				int price = set.getInt(5);
				
				System.out.println ("ID = " + pID + 
							", Prod Name = " + pName + 
							", Prod Desc = " + pDesc + 
							", Quantity = " + qty + 
							", Price = " + price );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
