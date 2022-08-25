package com.jdbcDemo.secondDemo.UserRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbcDemo.firstDemo.ConnectStudentDatabase;

public class UserDBController {
	
	public static boolean insertUserRegData(UserInfo uf) {
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
			
			return true;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		
		return false;
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
			
			
			//SET THE VALUES
//			pstmt.setInt(1, uf.getUserNo());
//			pstmt.setString(1, uf.getName());
//			pstmt.setString(2, uf.getMobNo());
//			pstmt.setString(3, uf.getUserName());
//			pstmt.setString(4, uf.getPassword());
//			
			//EXECUTE
//			pstmt.executeUpdate();
			
			return rs;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		return rs;
	}
}




