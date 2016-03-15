package org.struts.service;

import java.io.*;
import java.sql.*;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class AddItemService {
	
	
	public boolean addItem(AddItemModel am)
	{
		 try
	  		{
			 int id=0;
			 int catId=0;
	  			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
	  			String query="INSERT INTO item(item_name,item_desc,seller_id,image,cost,subCat_Id,field1,field2,advertisementItem,itemId,imagePath,ItemCatId ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
	  			preparedStmt.setString (1, am.getItemName());
	  			preparedStmt.setString (2, am.getItemDesc());
	  			preparedStmt.setString(3, am.getSellerId());
	  			if(am.getPic()!=null)
	    		{
	  				FileInputStream fis=new FileInputStream(am.getPic());
	  				preparedStmt.setBinaryStream(4,fis,(int)am.getPic().length());
	  				preparedStmt.setString(11,am.getPic().getAbsolutePath());
	    		}
	  			else
	  				{
	  				preparedStmt.setBinaryStream(4,null);
	  				preparedStmt.setString(11,null);
	  				}
	  			preparedStmt.setInt(5,am.getPrice());
	  			String query1="SELECT subcatId,categoryId from subcategory where subcatName=?";
				PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
				String subCat=am.getTest();
				prepStmt.setString(1,subCat);
				ResultSet rs1 = prepStmt.executeQuery();
				while (rs1.next()) {
					  id = rs1.getInt("subcatId");
					  catId = rs1.getInt("categoryId");
				  }
	  			preparedStmt.setInt(6,id);
	  			preparedStmt.setString(7,am.getAddField1());
	  			preparedStmt.setString(8,am.getAddField2()); 
	  			preparedStmt.setString(9,am.getAdvCheck());
	  			preparedStmt.setString(10,am.getItemId());
	  			System.out.println("11,am.getItemId() in service "+am.getItemId());
	  			preparedStmt.setInt(12,catId);
	  			preparedStmt.execute();
	  			return true;
	  			}
			 catch (SQLException e1) {
					e1.printStackTrace();
				}
			 catch (Exception e1) {
					e1.printStackTrace();
			}
		 return false;
	}
	public boolean validate(AddItemModel am) 
	{
		try
		{
		String query1="SELECT count(*) from item where itemId=?";
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
		prepStmt.setString(1,am.getItemId());
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
