package com.jdbcDemo.secondDemo.UserRegistration;

public class UserInfo {

	private int userNo;
	private String name;
	private String mobNo;
	private String userName;
	private String pass;
	
	public UserInfo(int userNo, String name, String mobNo, String userName, String pass) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.mobNo = mobNo;
		this.userName = userName;
		this.pass = pass;
	}
	
	public UserInfo(String name, String mobNo, String userName, String pass) {
		super();
		this.name = name;
		this.mobNo = mobNo;
		this.userName = userName;
		this.pass = pass;
	}

	
	public UserInfo(int userNo, String name, String mobNo,String userName ) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.mobNo = mobNo;
		this.userName = userName;
		this.pass = "-1";
	}
	
	public UserInfo() {
		System.out.println("userinfo");
	}

	public String getName() {

		return name;
	}

	public String getMobNo() {
		return mobNo;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return pass;
	}

	public int getUserNo() {
		// TODO Auto-generated method stub
		return userNo;
	}
	
	
//	public static void printUserData() {
//		
//	}
//	
//	public static void main()
	
}

