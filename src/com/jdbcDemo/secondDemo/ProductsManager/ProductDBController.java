package com.jdbcDemo.secondDemo.ProductsManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.sql.PreparedStatement;

public class ProductDBController {

	public static void showAllProduct() throws Exception {
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
//			System.out.println(con);

			String q = "SELECT * FROM productdata";

			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);

			while (set.next()) {
				int pID = set.getInt(1);
				String pName = set.getString(2);
				String pDesc = set.getString(3);
				int qty = set.getInt(4);
				int price = set.getInt(5);

				System.out.println("ID: " + pID + ",\t" + "ProdName: " + pName.trim() + ",\t" + "Type: " + pDesc.trim()
						+ ",\t" + "Qty: " + qty + ",\t" + "Price: " + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showProductAscendingOrd(String str) throws Exception {
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
//			System.out.println(con);

			String q = "SELECT * FROM productdata ORDER BY " + str + " DESC";

			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);

			while (set.next()) 
			{
				int pID = set.getInt(1);
				String pName = set.getString(2);
				String pDesc = set.getString(3);
				int qty = set.getInt(4);
				int price = set.getInt(5);


				System.out.println("ID: " + pID + ",\t" 
										+ "ProdName: " + pName.trim() 
										+ ",\t" + "Type: " + pDesc.trim()
										+ ",\t" + "Qty: " + qty 
										+ ",\t" + "Price: " + price);

			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void showProductByAscendingPrice() throws Exception {
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
			System.out.println(con);

			String q = "SELECT * FROM productdata ORDER BY price ";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(q);

			while (set.next()) {
				int pID = set.getInt(1);
				String pName = set.getString(2);
				String pDesc = set.getString(3);
				int qty = set.getInt(4);
				int price = set.getInt(5);

				System.out.println("ID = " + pID + ", Prod Name = " + pName + ", Prod Desc = " + pDesc + ", Quantity = "
						+ qty + ", Price = " + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getSelectedProductData(Set<Integer> pIDs) throws Exception {
		ResultSet rs = null;
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
			String q = "SELECT * FROM productdata WHERE pID IN (" + stringMakerOfMapKey(pIDs) + ")";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(q);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

	public static String stringMakerOfMapKey(Set<Integer> keys) {
		StringBuilder str = new StringBuilder();
//		Set<Integer> keys = cart.keySet();
		for (Integer key : keys) {
			str.append(key);
			str.append(",");
		}

		str.deleteCharAt(str.length() - 1);

		return str.toString();

	}
	
	public static void updateSelectedProductQty(HashMap<Integer, Integer> cart) throws Exception {
		
		HashMap<Integer, Integer> ava = new HashMap<Integer, Integer>();
		ResultSet rs = getSelectedProductData(cart.keySet());
		while(rs.next())
		{
			int pID = rs.getInt(1);

			int qty = rs.getInt(4) - cart.get(pID);
			qty = (qty<0) ? 0 : qty;
			ava.put(pID, qty);
		}
		
//		System.out.println(ava);
		
		try {
			Connection con = ProductDBConnection.ConnectproductDB();
			
			for (Integer id : ava.keySet()) 
			{
//				String q = "UPDATE productdata SET quantity = "+ ava.get(id).toString() + "WHERE pID = " + id.toString() ;
				String q = "UPDATE productdata SET quantity = " + ava.get(id) + " WHERE pID = "+id;

//				System.out.println(q);
				Statement stmt = con.createStatement();
				stmt.execute(q);
			}
//			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

//		UPDATE Customers
//		SET ContactName='Alfred Schmidt'
//		WHERE CustomerID=1;

	}

}
