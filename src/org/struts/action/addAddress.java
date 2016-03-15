package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.struts.utils.ConnectionPool;

public class addAddress {
	private String contactName,address,city,state,country;
	private int pincode,phone;
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String execute()throws SQLException
	{
		 if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
		 String c ="India";
		 String query = "insert into address(contactName,addr,pincode,city,state,phone,country)values(?,?,?,?,?,?,?)";
		 PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
		  preparedStmt.setString (1, getContactName());
	      preparedStmt.setString (2, getAddress());
	      preparedStmt.setInt(3, getPincode());
	      preparedStmt.setString (4, getCity());
	      preparedStmt.setString (5, getState());
	      preparedStmt.setInt(6, getPhone());
	      preparedStmt.setString(7, getCountry());
	      preparedStmt.execute();

		return "success";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
