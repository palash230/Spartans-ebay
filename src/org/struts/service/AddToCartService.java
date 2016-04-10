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
import org.struts.model.AddItemModel;
import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.model.Test;
import org.struts.utils.ConnectionPool;

public class AddToCartService {
	
	int total_cost=0;
	int flag=0,discount=0;
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
        	 
        	 boolean result = valid(atcm);
        	 if(result)
        	 {
        		 String q1="Select discount,expiryOn from item where itemId=?";
        		// System.out.println("Hiiiiii priyanka");
        			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
        			prepS1.setString(1, tst);
        			ResultSet rs1 = prepS1.executeQuery();
        			if(rs1.next())
        			{
        				//System.out.println("inside new code....");
        				discount = rs1.getInt("discount");
        			}
     			if(discount>0)
     			{
     				//System.out.println("here---------------------------->jjjjjjjj");
     				cost =cost-( (cost*discount)/100);
     			}
    
        		 
        		 
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
        	/* else
        	 {
        		 System.out.println("here inside else loop");
        		 String q="Update orders set quantity = quantity+? where userId=? and itemId=?";
     			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
     			prepS.setInt(1, 1);
     			prepS.setString(2, user);
     			prepS.setString(3, tst);
     		prepS.execute();
     		
        	 }*/
         }
		
		String q2 = "SELECT itemId , quantity FROM orders where userId=? and orderFlag=?";
		PreparedStatement ps1=ConnectionPool.con.prepareStatement(q2);
		  ps1.setString(1,user);
		  ps1.setString(2,"C");
		  ResultSet rs2 = ps1.executeQuery();
		  while(rs2.next())
		  {
			  String itemId= rs2.getString("itemId");
			  int quantity = rs2.getInt("quantity");
		
		String query="SELECT item_name,item_desc,cost,seller_id069,image,imagePath FROM item where itemId=?";
		
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
			//atc.setCost(rs.getString("cost"));
			atc.setSeller_id(rs.getString("seller_id069"));
			atc.setPhoto(rs.getBlob("image"));
			atc.setImagePath(rs.getString("imagePath"));
			Blob pic=rs.getBlob("image");
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				atc.setBlobAsBytes(pic.getBytes(1, blobLength));
				atc.setImage64encode(new Base64().encodeToString(atc.getBlobAsBytes()));
				}
			int costperItem=Integer.parseInt(rs.getString("cost"));
			int costFinal = quantity*costperItem;
			
			 String q1="Select discount,expiryOn from item where itemId=?";
			 System.out.println("Hiiiiii priyanka");
				PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
				prepS1.setString(1, itemId);
				ResultSet rs1 = prepS1.executeQuery();
				if(rs1.next())
				{
					//System.out.println("inside new code....");
					discount = rs1.getInt("discount");
				}
			
			if(discount>0)
 			{
 				costFinal =costFinal-( (costFinal*discount)/100);
 			}

			atc.setCost(costFinal);
			total_cost = total_cost + costFinal;
			atc.setQuantity(quantity);
			catModel.add(atc);
			/*session.setAttribute("quantity",quantity);*/
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
	
	
	public void updateItem(AddToCartModel atcm)
	{
		
		//Test atc = null;
		int actual_quantity=50;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		 HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
     int quantity = atcm.getQuantity();
     int cost = atcm.getCost();
     String q1="Select quantity from item where itemId=?";
		// System.out.println("Hiiiiii priyanka");
			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
			prepS1.setString(1, tst);
		//	System.out.println("");
			ResultSet rs1 = prepS1.executeQuery();
			if(rs1.next())
			{
				System.out.println("inside new code....");
			 actual_quantity= rs1.getInt("quantity");
			}
			System.out.println("quantity"+quantity+"aQ"+actual_quantity);
		
     if(quantity>actual_quantity)
    	 quantity=actual_quantity;
     if(quantity<=0)
    	 quantity=1;
       System.out.println("check----------->"+quantity+"    "+cost);
       
       System.out.println("check----------->"+user);
       System.out.println("check----------->"+tst);

		String q="Update orders set quantity = ? where userId=? and itemId=?";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setInt(1, quantity);
			prepS.setString(2, user);
			prepS.setString(3, tst);
		prepS.execute();
		atcm.setItemId(null);
		modelInitialization(atcm);
	}
		/* catch (SQLException e1) {
		e1.printStackTrace();
	}*/
	catch (Exception e1) {
		e1.printStackTrace();
	}

	}

	
	public boolean valid(AddToCartModel atcm) 
	{
		try
		{
		String query1="SELECT count(*) from orders where itemId=? and userId=? and orderFlag=?";
		String tst=atcm.getItemId();
		System.out.println("itemId---------------------------------->"+atcm.getItemId());
        String user = session.getAttribute("user").toString();
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
		prepStmt.setString(1,tst);
		prepStmt.setString(2,user);
		prepStmt.setString(3,"C");
		ResultSet rs1 = prepStmt.executeQuery();
		if(rs1.next())
		{
			int count=rs1.getInt(1);
			if(count==1)
				return false;
			else return true;
		}
		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
		return false;
	}

}


