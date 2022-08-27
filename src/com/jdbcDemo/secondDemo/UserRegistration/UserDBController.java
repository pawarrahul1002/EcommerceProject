package com.jdbcDemo.secondDemo.UserRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbcDemo.firstDemo.ConnectStudentDatabase;

public class UserDBController {
	
	public static int insertUserRegData(UserInfo uf) {
		try {
			
			//JDBC CODE
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "INSERT INTO userRegData (name,mobNo,userName,password) VALUES (?,?,?,?)";
			
			//PREAPRE STATEMENT
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			//SET THE VALUES
//			pstmt.setInt(1, uf.getUserNo());
			pstmt.setString(1, uf.getName());
			pstmt.setString(2, uf.getMobNo());
			pstmt.setString(3, uf.getUserName());
			pstmt.setString(4, uf.getPassword());
			
			//EXECUTE
			pstmt.executeUpdate();
			System.out.println("Added successfully.");
			
//			Connection conn = UserDBConnection.createUserDbConn();
			String lastUNoStr = "SELECT LAST_INSERT_ID()";
			
			//PREAPRE STATEMENT
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(lastUNoStr);
			if(rs.next())
			{

				System.out.println("unum : " + rs.getInt(1));
				return rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			//handle exception
			System.out.println("got some problems.");
			e.printStackTrace();
		}
		
		
		return -1;
	}
	
	public static ResultSet getAllUserData()
	{
		ResultSet rs = null;
		try {
			
			//JDBC CODE
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "SELECT * FROM userRegData";
			
			//PREAPRE STATEMENT
			Statement st = conn.createStatement();
			rs = st.executeQuery(q);
			return rs;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
//	public static int getUserNum(String userName, String password)
//	{
//		ResultSet rs = null;
//		try {
//			
//			//JDBC CODE
//			
//			//JDBC CODE
//			Connection conn = UserDBConnection.createUserDbConn();
//			String q = "SELECT userno FROM userRegData WHERE userName = \""+ userName+ "\" AND password = "+ password;
//			
//			//PREAPRE STATEMENT
//			Statement st = conn.createStatement();
//			rs = st.executeQuery(q);
//			rs.next();
////			System.out.println("user number found." + rs.getInt(1));
//			return rs.getInt(1);
//
//			
//			
//		}catch(Exception e) {
//			//handle exception
//
//			System.out.println("user number not found.");
//			e.printStackTrace();
//		}
//		return -1;
//	}
	
	public static UserInfo getUserInfoByUserNum(int userNum) {
		UserInfo uf  = new UserInfo();
		ResultSet rs = null;
		try {
			
			//JDBC CODE
			
			//JDBC CODE
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "SELECT * FROM userRegData WHERE userno = " +userNum;
			
			//PREAPRE STATEMENT
			Statement st = conn.createStatement();
			rs = st.executeQuery(q);
			if(rs.next())
			{
				uf  = new UserInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				System.out.println("user number found.");
			}
			return uf;

			
			
		}catch(Exception e) {
			//handle exception

			System.out.println("user number not found.");
			e.printStackTrace();
		}
		return uf;
	}
	
	public static int getlastUserNumber()
	{
		ResultSet rs = null;
		try {
			
			//JDBC CODE
			
			//JDBC CODE
			Connection conn = UserDBConnection.createUserDbConn();
			String q = "SELECT LAST_INSERT_ID()";
			
			//PREAPRE STATEMENT
			Statement st = conn.createStatement();
			rs = st.executeQuery(q);
			if(rs.next())
			{
				return rs.getInt(1);
			}
//			rs.next();
//			System.out.println("user number found." + rs.getInt(1));
			return rs.getInt(1);

			
			
		}catch(Exception e) {
			//handle exception

			System.out.println("user number not found.");
			e.printStackTrace();
		}
		return -1;
	}
	
}




