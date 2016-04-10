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
		String accountNumber="";
		ResultSet rs=st.executeQuery();
		if(rs.next()){
		//System.out.println("value---->"+rs.getString("expYear")+rs.getString("expMonth"));
			if((rs.getString("expYear").equals(pm.getExpYear()))&&(rs.getString("expMonth").equals(pm.getExpMonth()))&&(rs.getString("cvv").equals(pm.getCvv()))&&(rs.getString("accountHolderName").equals(pm.getHolderName())));
			{	//System.out.println("db..."+rs.getString("cvv"));
				HttpSession session = ServletActionContext.getRequest().getSession();
				System.out.println("check---->"+session.getAttribute("cost"));
				String userId=session.getAttribute("user").toString();
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
					pm.setUUID_Or();
					pm.setUUID_Pay();
					   System.out.println("orderId.........."+pm.getUUID_Or()+pm.getUUID_Pay()+userId);
					   String q2="UPDATE orders set orderFlag=? , orderId=? , paymentId=?,status=?,orderDate=? where userId=? and orderFlag=? ";
						PreparedStatement prep1 = ConnectionPool.con.prepareStatement(q2);
						prep1.setString(1,"B");
						
						prep1.setString(2,pm.getUUID_Or());
						prep1.setString(3,pm.getUUID_Pay());
						prep1.setString(4,"Payment Successful");
						prep1.setString(5,session.getAttribute("context").toString() );
						prep1.setString(6,userId);
						prep1.setString(7,"C");
						prep1.execute();
					
						String str="Insert into payment(paymentId,price,orderId,paymentType,debitAccount) values(?,?,?,?,?)";
						PreparedStatement ps = ConnectionPool.con.prepareStatement(str);
						ps.setString(1, pm.getUUID_Pay());
						ps.setInt(2, cost);
						ps.setString(3, pm.getUUID_Or());
						ps.setString(4, "debit");
						PreparedStatement s=ConnectionPool.con.prepareStatement("select accountNumber from account where cardNumber=?");
						s.setString(1, pm.getCardNumber());
						ResultSet rs1=s.executeQuery();
						if(rs1.next())
						{
							accountNumber=rs1.getString("accountNumber");
						}
						ps.setString(5, accountNumber);
					//	ps.setString(6, "Payment Successful");
						//ps.setString(6, session.getAttribute("context").toString() );
						ps.execute();
						   System.out.println("orderId.........."+pm.getUUID_Or()+pm.getUUID_Pay()+userId);
						   String q5="select item.itemId,orders.quantity from orders,item where item.itemId=orders.itemId and paymentId=?";
							PreparedStatement prep2 = ConnectionPool.con.prepareStatement(q5);
							prep2.setString(1,pm.getUUID_Pay());
							ResultSet rs4=prep2.executeQuery(); 
							
							while(rs4.next())
							{
								String tempitem=rs4.getString("item.ItemId");
								System.out.println(tempitem);
								String tempquantity=rs4.getString("Orders.quantity");
								System.out.println(tempquantity);
								String q6="update item set item.quantity=item.quantity-"+tempquantity+" where itemId="+"'"+tempitem+"'"+";";
								System.out.println(q6);
								PreparedStatement prep4 = ConnectionPool.con.prepareStatement(q6);
								prep4.execute();
							}
					
						
						
						    
						   
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
