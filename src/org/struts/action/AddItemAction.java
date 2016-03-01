package org.struts.action;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.commons.lang.StringUtils;
import org.struts.model.AddItemModel;
import org.struts.service.AddItemService;
import com.opensymphony.xwork2.ActionSupport;

public class AddItemAction extends ActionSupport implements ModelDriven {
	AddItemModel am =new AddItemModel();
	public String execute() {
		System.out.println("before call in add Item Action ");
		AddItemService addService=new AddItemService();
		System.out.println("Advertisement ??? "+am.getAdvCheck());
		if(addService.addItem(am))
		{	
			return SUCCESS;
		}
	      return ERROR;	    
}
	
	public String getDefaultCat()
	{
		return "0";
	}
	public void validate()
	{
		if(StringUtils.isEmpty(am.getItemId()))
		{
			System.out.println("validation checking of sellerid!!!! ");
			addFieldError("itemId", "Item Id can not be empty");
		}
		else
		{
			AddItemService addService=new AddItemService();
			if(!addService.validate(am))
			{
				System.out.println("Item Id already exixts ");
				addFieldError("itemId", "Item Id already exists");
			}
		}
		if(StringUtils.isEmpty(am.getItemName()))
		 {
		    addFieldError( "itemName", "Item Name is not selected." );
		 }
		 if(StringUtils.isEmpty(am.getItemDesc()))
		 {
			 
		    addFieldError( "itemDesc", "Item Description is not given." );
		 }
		 if(StringUtils.isEmpty(am.getSellerId()))
		 {
		    addFieldError( "sellerId", "Seller Id is not selected." );
		 }
		
		 if(am.getPrice()==0)
		 {
		    addFieldError( "price", "Price is not given." );
		 }
		if(am.getItem().equals("0"))
			 {
			    addFieldError( "item", "select category" );
			 }
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		System.out.println("calling model");
		return am;
	}
}