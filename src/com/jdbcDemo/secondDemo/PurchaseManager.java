package com.jdbcDemo.secondDemo;

import java.io.*;
import java.util.HashMap;

import com.jdbcDemo.secondDemo.UserRegistration.UserDBController;
import com.jdbcDemo.secondDemo.UserRegistration.UserInfo;
import com.jdbcDemo.secondDemo.ProductsManager.ProductDBController;
import com.jdbcDemo.secondDemo.UserCartManager.UserCartController;

public class PurchaseManager {

	public static void purchaseProduct(int userNum) throws Exception {
		String name;
		UserInfo uf = UserDBController.getUserInfoByUserNum(userNum);
		if (uf != null) {
			name = uf.getName();
			System.out.println("Welcome " + name);
		}

		HashMap<Integer, Integer> cart = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 0;
		do 
		{
			System.out.println("Please Enter Choice " + "\n1 View All Products" + "\n2 View Product By Sort"
					+ "\n3 Add Product To Cart" + "\n4 View Cart" + "\n5 Total Cart Price" + "\n6 CheckOut"
					+ "\n7 Exit");

			choice = Integer.parseInt(br.readLine());
			if ((choice == 4 || choice == 5 || choice == 6) && cart.isEmpty()) {
				System.out.println("Your Cart Is Empty \nPlease Choice Other Option");

				choice = Integer.parseInt(br.readLine());
			}

			switch (choice) {
			case 1:
				// view all
				ProductDBController.showAllProduct();
//				System.out.println("\n"
//						+ "Enter"
//						+ "\n1 Add TO Cart"
//						+ "\n2 Sort Products"
//						+ "\n3 Goto Cart");
//				
//				int c= Integer.parseInt(br.readLine());
//				switch(c)
//				{
//				case 1:
//					char yOrN;
//					do
//					{
//						System.out.println("Enter Product Id : ");
//						int id = Integer.parseInt(br.readLine());
//						
//						System.out.println("Enter Quantity : ");
//						int qty = Integer.parseInt(br.readLine());
//						
//						cart.put(id,qty);
//						
//						
//						System.out.println("Added To Cart (--/) \nWant To Add More (Y/N)");
//						yOrN = (char)br.read();
//						br.skip(2);
//					}while(yOrN == 'y' || yOrN == 'Y');
//					
//					
//					System.out.println("Enter Choice \n1 View Cart \n2 Total Amount");
//					System.out.println("3 CheckOut");
//
//					int n = Integer.parseInt(br.readLine());
//					if(n==1)
//					{
//						UserCartController.viewCart(cart,false);
//					}
//					else if(n==2)
//					{
//						UserCartController.viewCart(cart,true);		//pass true if wanna view price only
//					}
//				}
				break;
			case 2:
				// sort by
				String colName = "";
				System.out.println("\n" + "Sort By Product" + "\n1 IDs" + "\n2 Names" + "\n3 Types" + "\n4 Prices");
				int sNo = Integer.parseInt(br.readLine());
				switch (sNo) {
				case 1:
					colName = "pID";
					break;
				case 2:
					colName = "pName";
					break;
				case 3:
					colName = "pDesc";
					break;
				case 4:
					colName = "price";
					break;
				}

				ProductDBController.showProductAscendingOrd(colName);
				break;
			case 3:
				// add to cart
				char yOrN;
				do {
					System.out.println("Enter Product Id : ");
					int id = Integer.parseInt(br.readLine());

					System.out.println("Enter Quantity : ");
					int qty = Integer.parseInt(br.readLine());

					cart.put(id, qty);

					System.out.println("Added To Cart (--/) \nWant To Add More (Y/N)");
					yOrN = (char) br.read();
					br.skip(2);
				} while (yOrN == 'y' || yOrN == 'Y');

				break;
			case 4:
				UserCartController.viewCart(cart, false);

				break;
			case 5:
				UserCartController.viewCart(cart, true);

				break;
			case 6:
				// checkout
				checkout(cart);
				cart.clear();
				break;
			case 7:
				choice = 7;
				// Exit
				break;

			}
		} while (choice != 7);

	}

	public static void checkout(HashMap<Integer, Integer> cart) throws Exception {
		System.out.println("Items Are Delivered Shortly To Your Address\n");
		ProductDBController.updateSelectedProductQty(cart);
		System.out.println("Updated Products Quantities Are-->\n");
		ProductDBController.showAllProduct();

	}
}
