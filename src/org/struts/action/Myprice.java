package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.struts.utils.ConnectionPool;

public class Myprice {
	private String FromId;
	private String ToId;

	public String execute()
	{
		try
  		{
		if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
		String query="select price,priceto from pricefinal where idpricefinal=(select max(idpricefinal) from pricefinal)";
    	PreparedStatement   preparedStmt = ConnectionPool.con.prepareStatement(query);
    	ResultSet rs=preparedStmt.executeQuery("select seller_id,itemId,image,advertisementItem from item069");
    	FromId = rs.getString("price");
    	ToId=rs.getString("priceto");
  		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 	
        return "success";
	}

	public String getFromId() {
		return FromId;
	}

	public void setFromId(String fromId) {
		FromId = fromId;
	}

	public String getToId() {
		return ToId;
	}

	public void setToId(String toId) {
		ToId = toId;
	}

	
}
