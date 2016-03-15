package org.struts.service;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.model.Test;
import org.struts.utils.ConnectionPool;

public class AddToCartService {
	
	int total_cost=0;
	 HttpSession session = ServletActionContext.getRequest().getSession();


	public void modelInitialization(AddToCartModel atcm)
	{
		ArrayList<Test> catModel=new ArrayList<Test>();
		Test atc=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		int cost = atcm.getCost();
		String seller_id = atcm.getSellerId();
		// HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
         if(tst!=null)
         {
		String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, user);
			prepS.setString(2, tst);
			prepS.setString(3, seller_id);
			prepS.setInt(4, 1);
			prepS.setString(5,"C");
			prepS.setInt(6,cost);
		prepS.execute();
         }
		
		String q1 = "SELECT itemId FROM orders where userId=?";
		PreparedStatement ps1=ConnectionPool.con.prepareStatement(q1);
		  ps1.setString(1,user);
		  ResultSet rs1 = ps1.executeQuery();
		  while(rs1.next())
		  {
			  String itemId= rs1.getString("itemId");
		  
		
		String query="SELECT item_name,item_desc,cost,seller_id,image,imagePath FROM item where itemId=?";
		
		query+=";";
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		  prepStmt.setString(1,itemId);
		  ResultSet rs = prepStmt.executeQuery();
		  
		System.out.println(" query"+query);
	//	ResultSet rs = stmt.executeQuery(query);
	//	atcm.setItemList(new ArrayList<Test>());
		while (rs.next()) {
			System.out.println("Inside!!!!!!!!!!!!!!!!!!!!!!");
			atc=new Test();
			atc.setItemId(itemId);
			atc.setItemName(rs.getString("item_name"));
			atc.setItemDesc(rs.getString("item_desc"));
			atc.setCost(rs.getString("cost"));
			total_cost = total_cost + Integer.parseInt(rs.getString("cost"));
			atc.setSeller_id(rs.getString("seller_id"));
			atc.setPhoto(rs.getBlob("image"));
			atc.setImagePath(rs.getString("imagePath"));
			Blob pic=rs.getBlob("image");
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				atc.setBlobAsBytes(pic.getBytes(1, blobLength));
				atc.setImage64encode(new Base64().encodeToString(atc.getBlobAsBytes()));
				}
			catModel.add(atc);
			}
		}
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	//	System.out.println("catModel.size() "+catModel.size());
		atcm.addItemIdList(catModel);
		atcm.setTotal_cost(total_cost);
		System.out.println(" sizze is "+atcm.getItemList().size());
		System.out.println("cost is---------->"+total_cost);
        session.setAttribute("cost",total_cost);


}
	
	public void removeItem(AddToCartModel atcm)
	{
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		 HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
		String q="DELETE from orders where userId=? and itemId=?";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, user);
			prepS.setString(2, tst);
		prepS.execute();
		atcm.setItemId(null);
	}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}

	}
}


