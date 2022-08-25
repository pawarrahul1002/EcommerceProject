package com.jdbcDemo.firstDemo;

public class StudentData {

	private int id;
	private String name;
	private String mobNo;
	private String city;
	
	public StudentData()
	{
		super();
	}
	
	public StudentData(int id, String name, String mobNo, String city)
	{
		super();
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
		this.city = city;
	}
	
	public StudentData(String name, String mobNo, String city) {
		super();
		this.name = name;
		this.mobNo = mobNo;
		this.city = city;
	}
	
	//getters
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getMobNo()
	{
		return this.mobNo;
	}
	
	public String getCityName()
	{
		return this.city;
	}
	
	//setters
	public void setID(int id)
	{
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public void setCity(String city) {
		this.city = city;
	}


	
	//display
	@Override
	public String toString() {
		return "StudentData [id=" + id + 
							", name=" + name + 
							", mobNo=" + mobNo + 
							", city=" + city + "]";
	}
	
	
}
















































