package org.struts.service;

import java.sql.*;

import org.struts.model.DeleteModel;
import org.struts.utils.ConnectionPool;

public class DeleteItemService {
	
public void listItemKey(DeleteModel dm)
{
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
	Statement stmt = ConnectionPool.con.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT itemId, item_name,rowItemId from item069");
	while (rs.next()) {
		  String itemId = rs.getString(1);
		  String itemName = rs.getString(2);
		  System.out.println("Item id is : "+itemId + "\n");
		  dm.addItemIdList(itemId,itemName,rs.getInt(3));
		}
	}
	 catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 
}
public void deleteItem(DeleteModel dm)
{
	System.out.println("deleting in servie");
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
		String query="delete from item069 where itemId='"+dm.getItemId()+"';";
		System.out.println("dm.getItemId() "+dm.getItemId());
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		prepStmt.executeUpdate(query);
		
	}
	 catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 	
}
}
