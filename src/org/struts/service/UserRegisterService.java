package org.struts.service;

import java.sql.*;


import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class UserRegisterService {
	public boolean findByUserId(UserRegisterModel rm) {
		if (ConnectionPool.con != null) {
			try {
				System.out.println("checking if user present");
				PreparedStatement prepStatement = ConnectionPool.con.prepareStatement("select count(*) from user where emailId = ?");
				prepStatement.setString(1, rm.getEmail());

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
	public void registerIntoDataBase(UserRegisterModel rm)
	{
		 try
  		{
			 System.out.println("Inserting user in db");
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="INSERT INTO user(firstName,emailId,password,lastName) VALUES (?, ?, ? ,?)";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getFname());
  			preparedStmt.setString (2, rm.getEmail());
  			preparedStmt.setString (3, rm.getPassword());
  			preparedStmt.setString (4, rm.getLname());
  			
  			
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
