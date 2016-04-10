package org.struts.service;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class AddItemService {
	
	
	public boolean addItem(AddItemModel am)
	{
		 try
	  		{
			 
	  			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
	  			String query="INSERT INTO item(item_name,item_desc,seller_id069,image,cost,subCat_Id,field1,field2,advertisementItem,itemId,imagePath,ItemCatId,dealFlag,discount,expiryOn,quantity,numberofitemsold,warrantyperiod,color,weight,brand,expirydate,conditionoftheitem,advtid ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
	  			System.out.println("am.getSubCatId()"+am.getSubCatId());
	  			preparedStmt.setString(6,am.getSubCatId());
	  			preparedStmt.setString(7,am.getAddField1());
	  			preparedStmt.setString(8,am.getAddField2()); 
	  			preparedStmt.setString(9,am.getAdvCheck());
	  			preparedStmt.setString(10,am.getItemId());
	  			preparedStmt.setInt(12,Integer.parseInt(am.getCategoryId()));
	  			System.out.println("am.getDealFlag() "+am.getDealFlag());
	  			//preparedStmt.setString(13,am.getDealFlag());
	  			System.out.println("i m ok here");
	  			preparedStmt.setString(13,"Y");
	  			System.out.println("failed?");
	  			System.out.println(" am.getDiscount() "+ am.getDiscount());
	  			preparedStmt.setInt(14, am.getDiscount());
	  			preparedStmt.setString(15, am.getExpireOn());
	  			preparedStmt.setInt(16, am.getQuantity());
	  			preparedStmt.setString(17, "0");
	  			preparedStmt.setString(18, am.getWarranty());
	  			preparedStmt.setString(19, am.getColor());
	  			preparedStmt.setString(20, am.getWeight());
	  			preparedStmt.setString(21, am.getBrand());
	  			preparedStmt.setString(22, am.getExpireOn());
	  			preparedStmt.setString(23, am.getCondition());
	  			preparedStmt.setString(24, "adv"+	am.getItemId());
	  			preparedStmt.execute();
	  			
	  			if(am.getAdvCheck().equals("Y"))
	  			{
	  				String query1="INSERT INTO Advertismentdetail(advtid,cost,fromtable,totable)values(?,?,?,?)";
	  				PreparedStatement preparedStmt1 = ConnectionPool.con.prepareStatement(query1);
	  				preparedStmt1.setString(1, "adv"+am.getItemId());
	  				preparedStmt1.setString(2, am.getAdv_Cost());
	  				preparedStmt1.setString(3, am.getStartDate());
	  				preparedStmt1.setString(4, am.getEndDate());
	  				preparedStmt1.execute();
	  			}
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
	public void listCategory(AddItemModel dm)
	{
		System.out.println(" i m here finally for categoryList");
		System.out.println( "dm vaue "+dm.getItemId()+ " ~ "+dm.getItemDesc()+" ~ "+dm.getItemName());
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		Statement stmt = ConnectionPool.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT categoryName,categoryId from category");
		while (rs.next()) {
			  String categoryId = rs.getString("categoryId");
			  String categoryName = rs.getString("categoryName");
			  if(dm.getCategoryId()!=null && dm.getCategoryId().equals(categoryId))
				  dm.setCategoryName(categoryName);
			  dm.addCategoryList(categoryId,categoryName);
			}
			

		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 
	}
}

