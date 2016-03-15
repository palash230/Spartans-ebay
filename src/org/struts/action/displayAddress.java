package org.struts.action;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;


public class displayAddress {
	private ArrayList<address> addrList= new ArrayList<address>();
	private ArrayList<String> addressList = new ArrayList<String>();
	private String yourAddress;
 	 address add_obj;
	 
	public ArrayList<address> getAddrList() {  
	    return addrList;  
	}  
	public void setAddrList(ArrayList<address> list) {  
	    this.addrList = list;  
	}  
	public String execute() throws SQLException
	{
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        String user = session.getAttribute("user").toString();
        
		 if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
		 
		 PreparedStatement ps= ConnectionPool.con.prepareStatement("select * from address where userId=?");
		 
		 ps.setString(1, user);
		 ResultSet rs=ps.executeQuery();  
		 while(rs.next())
		 {
			 add_obj = new address();
			 System.out.println("m ooad_project........");
			 add_obj.setContactName(rs.getString(8));
			 add_obj.setAddress(rs.getString(2));
			 add_obj.setCity(rs.getString(3));
			 add_obj.setState(rs.getString(4));
			 add_obj.setCountry("India");
			 add_obj.setPincode(rs.getInt(6));
			 add_obj.setPhone(rs.getInt(7));
			 addrList.add(add_obj);
		 }
		 
		 for(address addr:addrList)
		 {
			 	String str;//full address
			 	str = addr.getContactName();
			 	str = str.concat("\n"+addr.getAddress());
			 	str = str.concat("\n"+addr.getCity());
			 	str = str.concat("\n"+addr.getState());
			 	str = str.concat("\n"+addr.getPincode());
			 	str = str.concat("\n"+addr.getCountry());
			 	str = str.concat("\n"+addr.getPhone());
			 	addressList.add(str);
		 }
	
		 for(String s:addressList)
			 System.out.println(s);
		 return "success";
		
	}
	public ArrayList<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(ArrayList<String> addressList) {
		this.addressList = addressList;
	}
	public String getYourAddress() {
		return yourAddress;
	}
	public void setYourAddress(String yourAddress) {
		this.yourAddress = yourAddress;
	}
	
}
