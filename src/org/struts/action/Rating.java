package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

public class Rating {

	private static  int rating=0;
	private String sellerId;

	public static  int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		Rating.rating = rating;
	}
	
	public String getsellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String execute() throws SQLException
		{
			 if(ConnectionPool.con==null)
		  			ConnectionPool.con=ConnectionPool.getConnection();
			 
			 //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx");
			 HttpSession session = ServletActionContext.getRequest().getSession();
			 String query="update seller set sellerrating='"+getRating()+"' where seller_id='"+getsellerId()+"'";
			 PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
			 boolean rs=ps.execute();  

		
		System.out.println(getRating()+ "     hbyg "+getsellerId()+ "  "+ps+"   "+rs);
		return "success";
	}
	
}
