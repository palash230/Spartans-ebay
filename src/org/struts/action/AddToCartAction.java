package org.struts.action;

import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.service.AddToCartService;
import org.struts.service.ItemByCatService;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AddToCartAction implements ModelDriven , Preparable {

	AddToCartModel atcm;
	public String execute()
	{
		System.out.println("i am in add to cart action");
		AddToCartService atcs=new AddToCartService();
		atcs.modelInitialization(atcm);
		System.out.println("returning here :)");
		return "success";
	}
	
	public String remove()
	{
		System.out.println("i am in add to remove action");
		AddToCartService atcs=new AddToCartService();
		atcs.removeItem(atcm);
		System.out.println("returning here :)");
		String abc = execute();
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return atcm;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
		atcm=new AddToCartModel();
		
	}
	
}