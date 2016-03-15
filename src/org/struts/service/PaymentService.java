package org.struts.service;
import java.sql.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.PaymentModel;
import org.struts.utils.ConnectionPool;
public class PaymentService {
	
	public boolean checkCardInfo(PaymentModel pm){
		try{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		PreparedStatement st=ConnectionPool.con.prepareStatement("select * from account where cardNumber=?");
		st.setString(1, pm.getCardNumber());
		
		ResultSet rs=st.executeQuery();
		if(rs.next()){
		//	System.out.println("value---->"+rs.getString("expYear")+rs.getString("expMonth"));
			if((rs.getString("expYear").equals(pm.getExpYear()))&&(rs.getString("expMonth").equals(pm.getExpMonth()))&&(rs.getString("cvv").equals(pm.getCvv()))&&(rs.getString("accountHolderName").equals(pm.getHolderName())));
			{	//System.out.println("db..."+rs.getString("cvv"));
				HttpSession session = ServletActionContext.getRequest().getSession();
				System.out.println("check---->"+session.getAttribute("cost"));

				int cost=Integer.parseInt(session.getAttribute("cost").toString());
				if(rs.getInt("balance")>=cost)
				{
					int balance = rs.getInt("balance")-cost;
					String q="UPDATE account set balance=? where cardNumber=?";
					PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
					prepS.setInt(1, balance);
					prepS.setString(2, pm.getCardNumber());
					prepS.execute();
					
					
					String q1="UPDATE account set balance=balance+? where userId=?";
					PreparedStatement prep = ConnectionPool.con.prepareStatement(q1);
					prep.setInt(1, cost);
					prep.setString(2, "ebay");
					prep.execute();
					
		        
				return true;
				}
			
			
				
			}
			
			
			
		}
		return false;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

}
	}
