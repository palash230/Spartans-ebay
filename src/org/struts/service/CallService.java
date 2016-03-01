package org.struts.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.struts.model.CallModel;
import org.struts.model.DeleteModel;
import org.struts.utils.ConnectionPool;

public class CallService {
	ArrayList<String> test;
	public void listItemKey(CallModel dm)
	{
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		Statement stmt = ConnectionPool.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT categoryName,categoryId from category");
		while (rs.next()) {
			test= new ArrayList<String>();
			  String categoryId = rs.getString("categoryId");
			  String categoryName = rs.getString("categoryName");
			  String query="SELECT subcatName from subcategory where categoryid=?";
			  PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
			  prepStmt.setString(1,categoryId);
			  ResultSet rs1 = prepStmt.executeQuery();
			  while (rs1.next()) {
				  String sub = rs1.getString("subcatName");
				  test.add(sub);
			  }
			  dm.addItemIdList(categoryName,test);
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
