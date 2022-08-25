package com.jdbcDemo.secondDemo;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jdbcDemo.secondDemo.UserRegistration.UserDBController;
import com.jdbcDemo.secondDemo.UserRegistration.UserInfo;


public class Start 
{
	
	
	enum eUInfo {
		  Name,
		  MobNo,
		  UserName,
		  Password
		}
	
	public static void main(String[] args) throws Exception
	{
		boolean isLogged = false;
		System.out.println("Welcome to App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 Register \n2 login \n3 exit");
		switch(Integer.parseInt(br.readLine()))
		{
			case 1:							//registration 
				addDetails();
				
			case 2:							//login
				
				while(!isLogged)
				{	
					isLogged = checkIsLoggedIn();
					
					if(isLogged)
					{
						break;
					}
					else
					{
						System.out.println("Wrong UserName or Password");
	
						System.out.println("1 Try Again \n2 Register \n3 exit");
						if(Integer.parseInt(br.readLine())==2)
						{			//registration 
							addDetails();
							isLogged = true;
						}
						else if(Integer.parseInt(br.readLine())==3)
						{
							System.out.println("Thanks For Using Application");
							System.exit(0);
						}
					}
				}
				
				if(isLogged)
				{
					System.out.println("Welcome To Home");
				}
				
				
				
				break;
			case 3:							//exit
				System.out.println("Thanks For Using Application");
				System.exit(0);
				break;
			
		}
	}
	
	public static void addDetails() throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter name");
		String name = br.readLine();
		
		System.out.println("enter mob no");
		String mobNo = br.readLine();
		
		System.out.println("enter usename");
		String userName = br.readLine();
		
		System.out.println("enter password");
		String pass = br.readLine();
	
		UserInfo uf = new UserInfo(name,mobNo, userName, pass);

		boolean res = UserDBController.insertUserRegData(uf);
		if(res)
		{
			System.out.println("Added successfully.");
		}
		else 
		{
			System.out.println("Something went wrong.. got errors");
			
		}
	}
	
	
	public static boolean checkIsLoggedIn() throws IOException, SQLException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("2");
		System.out.println("enter usename");
		String uName = br.readLine();
		System.out.println("enter password");
		String passWord = br.readLine();
		ResultSet rs = UserDBController.getAllUserData();
		while(rs.next())
		{

			if(uName.contentEquals(rs.getString(4)) && passWord.contentEquals(rs.getString(5)))
			{
				System.out.println("Login Successful");
				
				return true;
			}
		}
		
		return false;
	}

	
	public void purchaseProduct()
	{
		
	}
}
	




//Commented

//int pID = set.getInt(1);
//String pName = set.getString(2);
//String pDesc = set.getString(3);
//int qty = set.getInt(4);
//int price = set.getInt(5);					
//System.out.println (" username = " + rs.getString(4) + " password = " + rs.getString(5) +"\n" );



//'17', 'Rahul Pawar', '9146', 'pawarrahul', '9146'



//if (isRegistered) 
//{
//	System.out.println("2 Login \n3 Exit");
//} 
//else 
//{
//	System.out.println("1 Register \n2 Login \n3 Exit");
//}




//System.out.println("1");
//
//System.out.println("enter name");
//String name = br.readLine();
//
//System.out.println("enter mob no");
//String mobNo = br.readLine();
//
//System.out.println("enter usename");
//String userName = br.readLine();
//
//System.out.println("enter password");
//String pass = br.readLine();
//
//UserInfo uf = new UserInfo(name,mobNo, userName, pass);
//
//boolean res = UserDBController.insertUserRegData(uf);
//if(res)
//{
//	System.out.println("Added successfully.");
//}
//else 
//{
//	System.out.println("Something went wrong.. got errors");
//	
//}
//break;




































