package org.struts.service;

import java.sql.*;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class RegisterSellerService {
	public boolean findBySellerId(RegisterModel rm) {
		if (ConnectionPool.con != null) {
			try {
				PreparedStatement prepStatement = ConnectionPool.con.prepareStatement("select count(*) from seller where seller_id = ?");
				prepStatement.setString(1, rm.getSellerId());

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getInt(1) == 1) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public void registerIntoDataBase(RegisterModel rm)
	{
		 try
  		{
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="INSERT INTO seller(name,shipping_address,seller_id,password) VALUES (?, ?, ? ,?)";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getSellerName());
  			preparedStmt.setString (2, rm.getSellerAdd());
  			preparedStmt.setString (3, rm.getSellerId());
  			preparedStmt.setString (4, rm.getPass());
  			
  			System.out.println("sellerId from service method"+rm.getSellerId()+" password "+rm.getPass());
  			preparedStmt.execute();
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
}
