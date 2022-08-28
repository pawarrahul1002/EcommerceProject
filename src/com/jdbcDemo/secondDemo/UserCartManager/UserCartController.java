package com.jdbcDemo.secondDemo.UserCartManager;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Set;

import com.jdbcDemo.secondDemo.ProductsManager.ProductDBController;

public class UserCartController {

//	public static void main(String[] args)
//	{
////		UserCartConnector uc = new UserCartConnector();
//		Connection con = UserCartConnector.connectCartDB();
//		System.out.println("Connected " + con);
//	}

	public static void viewCart(HashMap<Integer, Integer> cart, boolean needPriceOnly) throws Exception {
		
		
		ResultSet rs = ProductDBController.getSelectedProductData(cart.keySet());

		int totalPrice = 0;

		while (rs.next()) {
			int pID = rs.getInt(1);

			int price = rs.getInt(5);
			String pName = rs.getString(2);
			String pDesc = rs.getString(3);

			int avaQuant = rs.getInt(4);
//			int avaQuant = Integer.parseInt(rs.getString(3));
			
			if (avaQuant >= cart.get(pID)) 
			{
				totalPrice += price * cart.get(pID);
			}else
			{
				if(avaQuant==0)
				{
					System.out.println(pName + " Is Out Of Stock..");
					cart.remove(pID);
				}else
				{
					System.out.println(pName + " Is Out Of Stock.. Only "+avaQuant+" Quantities Avaialble.");
					totalPrice += price * avaQuant;
					cart.replace(pID, avaQuant);
				}
			}
			
			if (!needPriceOnly && (avaQuant!=0) ) {
				System.out.println("ID = "  + pID + ", Prod Name = " 
											+ pName + ", Prod Desc = " 
											+ pDesc + ", Quantity = "
											+ cart.get(pID) + ", Price = " + price);
			}
		}
		
		System.out.println("\nTotal Price Of Products In Cart : " + totalPrice);

	}
	
	
	

}























