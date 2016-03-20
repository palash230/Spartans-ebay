package org.struts.action;
import java.util.Date;

 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
 
import com.opensymphony.xwork2.*;
 
public class LogoutAction extends ActionSupport {
 
    public String execute() throws Exception { 
    	System.out.println("Logging out");
    	HttpSession session = ServletActionContext.getRequest().getSession(false);
    	session.removeAttribute("logined");
    	session.removeAttribute("context");
    	session.removeAttribute("user");
    	session.removeAttribute("type");
        return SUCCESS;
    }
 
}