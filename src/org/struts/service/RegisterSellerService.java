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
							System.out.println("bbcudbuwbew"+result.getInt(1));
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("bbcudbuwbew  outside");

		return false;
	}
	public void registerIntoDataBase(RegisterModel rm)
	{
		 try
  		{
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="INSERT INTO seller(name,shipping_address,seller_id,password,emailid,contactnumber,natureofbusiness,categoryofproducts) VALUES (?, ?, ? ,?, ?, ?, ? ,?)";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getSellerName());
  			preparedStmt.setString (2, rm.getSellerAdd());
  			preparedStmt.setString (3, rm.getSellerId());
  			preparedStmt.setString (4, rm.getPass());
  			preparedStmt.setString (5, rm.getEmail());

  			preparedStmt.setString (6, rm.getContact());
  			preparedStmt.setString (7, rm.getNature());
  			preparedStmt.setString (8, rm.getCatProduct());

  			
  			
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