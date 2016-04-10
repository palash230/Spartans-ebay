package org.struts.action;
import org.struts.model.ItemByCatModel;
import org.struts.service.dealsService;

import com.opensymphony.xwork2.ModelDriven;

public class dealsAction implements ModelDriven{

	ItemByCatModel tcm=new ItemByCatModel();
	
	public String execute()
	{
		System.out.println("I am in DEALS ");
		dealsService ds=new dealsService();
		ds.modelInitialization(tcm);
		System.out.println("back in deal action");
		
		return "success";
		
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tcm;
	}

}
