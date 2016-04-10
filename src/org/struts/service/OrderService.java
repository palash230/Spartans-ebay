package org.struts.service;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.OrderModel;
import org.struts.utils.ConnectionPool;

public class OrderService {
	public boolean listOrder(OrderModel om)
	{
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			HttpSession session = ServletActionContext.getRequest().getSession();
			String uType=session.getAttribute("type").toString();
			System.out.println(" session value is "+session.getAttribute("user"));
			if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
				return false;
			String date = "yyyy-MM-dd"; 
			Calendar calendar = Calendar.getInstance();     
			SimpleDateFormat dateFormat = new SimpleDateFormat(date);       
			System.out.println("Today Date = "+dateFormat.format(calendar.getTime()));
			//System.out.println("difference of date "+dateFormat.format(calendar.getTime())-2015-03-01'<=30);
			//String query="SELECT * from orders where userId=? and datediff(CURDATE(),orderDate)<=90";
			String query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address " +
					"from orders o,item i " +
					"where o.userId=?  and  orderFlag='B'" +
					" and i.itemId=o.itemId";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString(1, (String)session.getAttribute("user"));
  			//preparedStmt.setString(2, (String)session.getAttribute("user"));
			ResultSet rs = preparedStmt.executeQuery();
			OrderModel o;
			om.setOrderList(new ArrayList<OrderModel>());
			while (rs.next()) {
				System.out.println("here   ");
				o=new OrderModel();
				System.out.println("inserting in Track my order");
				o.setOrderId(rs.getString("orderId"));
				//o.setUserId(rs.getString("userName"));
				Blob pic=rs.getBlob("image");
				if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				o.setImage64encode(new Base64().encodeToString(pic.getBytes(1, blobLength)));
				}
				
				o.setItemId(rs.getString("itemId"));
				o.setItemDesc(rs.getString("item_desc"));
				o.setSellerId(rs.getString("sellerId"));
				o.setQuantity(rs.getString("quantity"));
				o.setItemName(rs.getString("item_name"));
				o.setStatus(rs.getString("status"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setPaymentId(rs.getString("paymentId"));
				o.setOrderFlag(rs.getString("orderFlag"));
				o.setPrice(rs.getString("price"));
				o.setAddress(rs.getString("address"));
				o.setRating();
				//om.setAddress(rs.getString("address"));
				o.setStatusList(new ArrayList<String>());
				System.out.println("userType--------->"+uType);
				
				

				if(rs.getString("status").equals("Approved")  || rs.getString("status").equals("Payment Successful"))
				{
					o.getStatusList().add("Approved");
					o.getStatusList().add("Delivered");
				}
				else if(rs.getString("status").equals("Delivered"))
				{
					o.getStatusList().add("Delivered");
					o.getStatusList().add("Received");
				}
				else 
				{
					
					o.getStatusList().add("Received");
				}
				om.getOrderList().add(o);
				
			}
		}
			 catch (SQLException e1) {
					e1.printStackTrace();
					return false;
				}
			 catch (Exception e1) {
					e1.printStackTrace();
					return false;
			}
		
		 System.out.println("om size"+om.getOrderList().size());
		return true;	
	}
	
	public boolean listOrder1(OrderModel om)
	{
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			HttpSession session = ServletActionContext.getRequest().getSession();
			String uType=session.getAttribute("type").toString();
			System.out.println(" session value is1111 "+session.getAttribute("user"));
			if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
				return false;
			String date = "yyyy-MM-dd"; 
			Calendar calendar = Calendar.getInstance();     
			SimpleDateFormat dateFormat = new SimpleDateFormat(date);       
			System.out.println("Today Date = "+dateFormat.format(calendar.getTime()));
			//System.out.println("difference of date "+dateFormat.format(calendar.getTime())-2015-03-01'<=30);
			//String query="SELECT * from orders where userId=? and datediff(CURDATE(),orderDate)<=90";
			String query;
			if(uType.equals("seller"))
			query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address " +
					"from orders o,item i " +
					"where sellerId =? and  orderFlag='B'" +
					" and i.itemId=o.itemId";
			else
			query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address " +
					"from orders o,item i " +
					"where userId =? and  orderFlag='B'" +
					" and i.itemId=o.itemId";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString(1, (String)session.getAttribute("user"));
  			//preparedStmt.setString(2, (String)session.getAttribute("user"));
			ResultSet rs = preparedStmt.executeQuery();
			OrderModel o;
			om.setOrderList(new ArrayList<OrderModel>());
			while (rs.next()) {
				o=new OrderModel();
				System.out.println("inserting in Track my order");
				o.setOrderId(rs.getString("orderId"));
				//o.setUserId(rs.getString("userName"));
				Blob pic=rs.getBlob("image");
				if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				o.setImage64encode(new Base64().encodeToString(pic.getBytes(1, blobLength)));
				}
				o.setItemId(rs.getString("itemId"));
				o.setItemDesc(rs.getString("item_desc"));
				o.setSellerId(rs.getString("sellerId"));
				o.setQuantity(rs.getString("quantity"));
				o.setItemName(rs.getString("item_name"));
				o.setStatus(rs.getString("status"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setPaymentId(rs.getString("paymentId"));
				o.setOrderFlag(rs.getString("orderFlag"));
				o.setPrice(rs.getString("price"));
				o.setAddress(rs.getString("address"));
				//om.setAddress(rs.getString("address"));
				o.setStatusList(new ArrayList<String>());
				System.out.println("userType--------->"+uType);
				
				

				if(rs.getString("status").equals("Approved")  || rs.getString("status").equals("Payment Successful"))
				{
					System.out.println("i m here");
					o.getStatusList().add("Approved");
					o.getStatusList().add("Delivered");
				}
				else if(rs.getString("status").equals("Delivered"))
				{
					o.getStatusList().add("Delivered");
					o.getStatusList().add("Received");
				}
				else 
				{
					
					o.getStatusList().add("Received");
				}
				om.getOrderList().add(o);
				
			}
		}
			 catch (SQLException e1) {
					e1.printStackTrace();
					return false;
				}
			 catch (Exception e1) {
					e1.printStackTrace();
					return false;
			}
		
		 System.out.println("om size"+om.getOrderList().size());
		return true;	
	}
	
}