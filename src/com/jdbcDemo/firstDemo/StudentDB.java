package com.jdbcDemo.firstDemo;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDB {

	public static boolean insertToDB(StudentData st)
	{
		try {
			
			//JDBC CODE
			Connection conn = ConnectStudentDatabase.CreateConnection();
			String q = "INSERT INTO student (sName,sMobNo,sCity) VALUES (?,?,?)";
			
			//PREAPRE STATEMENT
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			//SET THE VALUES
			pstmt.setString(1, st.getName());
			pstmt.setString(2, st.getMobNo());
			pstmt.setString(3, st.getCityName());
			
			//EXECUTE
			pstmt.executeUpdate();
			
			return true;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean deleteStudentData(int id)
	{
		try {
			
			//JDBC CODE
			Connection conn = ConnectStudentDatabase.CreateConnection();
			String q = "DELETE FROM student WHERE sID=? ";
			
			//PREAPRE STATEMENT
			PreparedStatement pstmt = conn.prepareStatement(q);
			
			//SET THE VALUES
			pstmt.setInt(1, id);
			
			//EXECUTE
			pstmt.executeUpdate();
			
			return true;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		
		return false;
	
		
	}

	public static boolean showAllStudent() {

		try {
			
			//JDBC CODE
			Connection conn = ConnectStudentDatabase.CreateConnection();
			String q = "SELECT * FROM student ";
			
			//PREAPRE STATEMENT
			Statement stmt = conn.createStatement();

			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String mobNo = set.getString(3);
				String city = set.getString(4);
				
				System.out.println ("id=" + id + 
							", name=" + name + 
							", mobNo=" + mobNo + 
							", city=" + city + "]");
				
				System.out.println ("-----------");
			}
			
			return true;
			
			
		}catch(Exception e) {
			//handle exception
			e.printStackTrace();
		}
		
		return false;
	
		
	
		
	}
}



































































