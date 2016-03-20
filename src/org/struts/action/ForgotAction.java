package org.struts.action;

import java.sql.*;

import java.util.Date;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.*;

public class ForgotAction extends ActionSupport {
        private static final long serialVersionUID = 1L;
        private String emailId;

    public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

	public String execute() throws Exception {
       // System.out.println("hellow"+userId+"--"+passwd);
		System.out.println("password change requested for"+emailId);
         HttpSession session = ServletActionContext.getRequest().getSession();
         if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
         String query="select * from user where emailId='"+emailId+"'";
         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
         ResultSet rs=preparedStmt.executeQuery();
       // System.out.println("hellp");
        //System.out.println("username:"+userId+"  passwd"+passwd);
        
      while(rs.next())
      {
                return "success";    
      }
     // System.out.println("returning error");
      return "error";
  }

  public String logout() throws Exception {
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.removeAttribute("logined");
      session.removeAttribute("context");
      session.removeAttribute("user");
      session.removeAttribute("type");
//Map session = ActionContext.getContext().getSession();
//session.remove("logined");
 //     session.remove("context");
      return "success";
  }

}

