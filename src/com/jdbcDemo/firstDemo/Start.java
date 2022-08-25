package com.jdbcDemo.firstDemo;

import java.io.*;

public class Start {
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.out.println("Student Management Application");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("press 1 : Add");
			System.out.println("2 : Delete");
			System.out.println("3 : Display");
			System.out.println("4 : Exit");
			
			int c = Integer.parseInt(br.readLine());
			
			switch(c)
			{
				case 1:
					//add student
					System.out.println("Add following data and press enter");
					
					
					System.out.println("enter name");
					String name = br.readLine();
					
					System.out.println("enter mob no");
					String mobNo = br.readLine();
					
					System.out.println("enter city");
					String city = br.readLine();
					
					//create student data to store data
					
					StudentData sd = new StudentData(name,mobNo, city);
					System.out.println(sd);
					
					boolean result = StudentDB.insertToDB(sd);
					
					if(result)
					{
						System.out.println("Added successfully.");
					}
					else 
					{
						System.out.println("Something went wrong.. got errors");
						c=4;
						break;
					}
					
					break;
				case 2 :
					//delete student
					System.out.println("enter ID to  delete data.");
					int id = Integer.parseInt(br.readLine());
					
					
					
					if(StudentDB.deleteStudentData(id))
					{
						System.out.println("deleted successfully.");
					}
					else 
					{
						System.out.println("Something went wrong.. u got errors!!");
						c=4;
					}
					break;
				case 3:
					//display student

					System.out.println("Available Students Data");
					if(!StudentDB.showAllStudent())
					{
						System.out.println("Something went wrong.. u got errors!!");
						c=4;
					}
					break;
				case 4:
					break;
				default:
					System.out.println("Entered wrong number.. Try again");
					break;
			}
			
			if(c==4)
			{
				break;
			}
		}
		System.out.println();
		System.out.println("Thanks For Using Student Management Application.");

	}
}
































