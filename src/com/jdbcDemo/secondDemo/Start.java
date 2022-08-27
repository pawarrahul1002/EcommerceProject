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
//		System.out.println(UserDBController.getUserNum("bzp","12345"));
		
//		boolean isLogged = false;
		int userNum = -1;
		System.out.println("Welcome to App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 Register \n2 login \n3 exit");
		switch(Integer.parseInt(br.readLine()))
		{
			case 1:							//registration 
				userNum = addDetails();

				if(userNum !=-1)
				{
					PurchaseManager.purchaseProduct(userNum);
				}
				break;
				
			case 2:							//login
				
				while(userNum == -1)
				{	
					userNum = checkIsLoggedIn();
					
					if(userNum !=-1)
					{
						PurchaseManager.purchaseProduct(userNum);
					}
					else
					{
						System.out.println("Wrong UserName or Password");
	
						System.out.println("1 Try Again \n2 Register \n3 exit");
						int choice = Integer.parseInt(br.readLine());
						if(choice==2)
						{			//registration 
							userNum = addDetails();
						}
						else if(choice==3)
						{
							System.out.println("Thanks For Using Application");
							System.exit(0);
						}
					}
					
					
				}
				
	
				
				
				
			case 3:							//exit
				System.out.println("Thanks For Using Application");
				System.exit(0);
				break;
			
		}
		

		System.out.println("Exit");
		
	}
	
	public static int addDetails() throws Exception
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
		int userNum  = UserDBController.insertUserRegData(uf);
		
		return userNum;
	}
	
	
	public static int checkIsLoggedIn() throws IOException, SQLException 
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
				int userNum = Integer.parseInt(rs.getString(1));
				return userNum;
			}
		}
		
		return -1;
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

//'16', 'binod', '2222', 'nayak', 'sdqa'


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




































