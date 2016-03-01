package org.struts.action;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.commons.lang.StringUtils;
import org.struts.model.AddPriceModel;
import org.struts.service.AddPriceService;
import com.opensymphony.xwork2.ActionSupport;

public class PriceAction extends ActionSupport implements ModelDriven {
	AddPriceModel am =new AddPriceModel();
	public String execute() {
		System.out.println("before call in add Item Action ");
		AddPriceService addService=new AddPriceService();
		if(addService.addItem(am))
		{	
			return SUCCESS;
		}
	      return ERROR;	    
}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		System.out.println("calling model");
		return am;
	}
}
