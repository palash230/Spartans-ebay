package org.struts.service;

import java.io.*;
import java.sql.*;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class AddPriceService {
	
	
	public boolean addItem(AddPriceModel am)
	{
		 try
	  		{
	  			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
	  			String query="INSERT INTO pricefinal(price,priceto ) VALUES (?,?)";
	  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
	  			preparedStmt.setString (1, am.getFromId());
	  			preparedStmt.setString (2, am.getToId());
	  			preparedStmt.execute();
	  			return true;
	  			}
			 catch (SQLException e1) {
					e1.printStackTrace();
				}
			 catch (Exception e1) {
					e1.printStackTrace();
			}
		 return false;}
}