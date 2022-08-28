package com.jdbcDemo.secondDemo;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcDemo.secondDemo.ProductsManager.ProductDBController;
import com.jdbcDemo.secondDemo.UserHistoryManager.AllUserHistoryController;
import com.jdbcDemo.secondDemo.UserRegistration.UserDBController;
import com.jdbcDemo.secondDemo.UserRegistration.UserInfo;

public class Start {

	enum eUInfo {
		Name, MobNo, UserName, Password
	}

	public static void main(String[] args) throws Exception {

		int userNum = -1;
		System.out.println("Welcome to App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 Register \n2 Login \n3 Admin Login \n4 Exit");
		
		switch (Integer.parseInt(br.readLine())) {
		case 1: // registration
			userNum = addDetails();

			if (userNum != -1) {
				PurchaseManager.purchaseProduct(userNum);
			}
			break;

		case 2: // login

			while (userNum == -1) {
				userNum = checkIsLoggedIn();

				if (userNum != -1) {
					PurchaseManager.purchaseProduct(userNum);
				} else {
					System.out.println("Wrong UserName or Password");

					System.out.println("1 Try Again \n2 Register \n3 exit");
					int choice = Integer.parseInt(br.readLine());
					if (choice == 2) { // registration
						userNum = addDetails();
					} else if (choice == 3) {
						System.out.println("Thanks For Using Application");
						System.exit(0);
					}
				}

			}
		case 3: // exit
			System.out.println("Welcome Admin");
				while(true) {
				System.out.println("What You Want To View "
									+ "\n1 All Product With Quantities"
									+ "\n2 User Registered List"
									+ "\n3 All User Purchase Histories "
									+ "\n4 Perticular User History"
									+ "\n5 Exit");
				int c = Integer.parseInt(br.readLine());
				if(c==5)
				{
					break;
				}
				if(c==4)
				{
					System.out.println("Enter User Number : ");
					int uNo = Integer.parseInt(br.readLine());
					AdminOperations(c,uNo);
				}
				else
				{
					AdminOperations(c,-1);
					
				}
			}
			break;
		case 4: // exit
			System.out.println("Thank You");
			
			break;

		}

		System.out.println("Thanks For Using Application");
		System.exit(0);
	}
	
	
	public static void AdminOperations(int c, int uNo) throws Exception
	{
		switch(c)
		{
		case 1:	//view all  products

			ProductDBController.showAllProduct();
			break;
		case 2: // User Registered List
			UserDBController.printAllRegisteredUserData();
			break;
		case 3: // All User Purchase Histories 
			AllUserHistoryController.printAllUserHistory();
			break;
		case 4: // Perticular User History
			AllUserHistoryController.printSelectedUserHistory(uNo);
			break;
		case 5: // Exit
			return;
			
		}
	}
	
	
	
	
	

	public static int addDetails() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name");
		String name = br.readLine();

		System.out.println("Enter Mob No");
		String mobNo = br.readLine();

		System.out.println("Enter Username");
		String userName = br.readLine();

		System.out.println("Enter Password");
		String pass = br.readLine();

		UserInfo uf = new UserInfo(name, mobNo, userName, pass);
		int userNum = UserDBController.insertUserRegData(uf);

		return userNum;
	}

	public static int checkIsLoggedIn() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("2");
		System.out.println("Enter Username");
		String uName = br.readLine();
		System.out.println("Enter Password");
		String passWord = br.readLine();
		ResultSet rs = UserDBController.getAllUserRegData();
		while (rs.next()) {

			if (uName.contentEquals(rs.getString(4)) && passWord.contentEquals(rs.getString(5))) {
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
