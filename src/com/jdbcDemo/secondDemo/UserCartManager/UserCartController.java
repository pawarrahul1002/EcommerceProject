package com.jdbcDemo.secondDemo.UserCartManager;

import java.sql.Connection;

public class UserCartController {

	public static void main(String[] args)
	{
//		UserCartConnector uc = new UserCartConnector();
		Connection con = UserCartConnector.connectCartDB();
		System.out.println("Connected " + con);
	}
}
