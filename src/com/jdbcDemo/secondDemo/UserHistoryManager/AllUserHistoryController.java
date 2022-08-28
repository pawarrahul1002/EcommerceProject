package com.jdbcDemo.secondDemo.UserHistoryManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.jdbcDemo.secondDemo.UserRegistration.UserDBConnection;
import com.jdbcDemo.secondDemo.UserRegistration.UserInfo;

public class AllUserHistoryController
{
	public static void insertToUserHistory(HashMap<Integer,Integer> cart, UserInfo uf)
	{
		try {
			
			Connection conn = UserDBConnection.createUserDbConn();
			int userNum = uf.getUserNo();

			System.out.println("\nUser History Added --->\n\n");
			for(int pID : cart.keySet())
			{
				String q = "INSERT INTO user_history(userno,pID,bQuant) "
							+ "VALUES ("+ userNum + ","+ pID + ","+ cart.get(pID)+")";
						
//						INSERT INTO userCart(pID,pName,pDesc,bQuant,cPrice)
//						VALUES (11, "Samsung-Galaxy","Mobile",1,500);
						
				Statement stmt = conn.createStatement();
				stmt.execute(q);
				System.out.println(userNum + " " + pID + " " + cart.get(pID));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void printAllUserHistory() {
		try {
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "SELECT * FROM user_history";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(q);
//			if(rs.next())
//			{
//				System.out.println("User History Found-->");
//			}
//			else
//			{
//				System.out.println("No Data Found");
//				return;
//			}
			while(rs.next())
			{
				System.out.println("UserNum : " + rs.getInt(1) + " ProductId :"+rs.getInt(2) + " Quantity : "+ rs.getInt(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void printSelectedUserHistory(int userNum) {
		try {
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "SELECT * FROM user_history WHERE userno = " +userNum;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(q);
//			if(rs.next())
//			{
//				System.out.println("User History Found-->");
//			}
//			else
//			{
//				System.out.println("No User History Found For UserNumber "+ userNum);
//				return;
//			}
			while(rs.next())
			{
				System.out.println("UserNum : " + rs.getInt(1) + " ProductId :"+rs.getInt(2) + " Quantity : "+ rs.getInt(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
