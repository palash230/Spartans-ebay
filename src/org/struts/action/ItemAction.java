package org.struts.action;


import com.opensymphony.xwork2.ActionSupport;
public  class ItemAction extends ActionSupport{
	private int itemOption;
	public String execute()
	{
		System.out.println(" i m in itemAction java and value of item selected is "+itemOption);
		if(itemOption==1)
		{
			System.out.println("calling add jsp inside ItemAction");
			return "Add";
		}
		else
		{
			System.out.println("calling delete jsp inside ItemAction");
			DeleteItemAction ds=new DeleteItemAction();
			ds.execute();
			return "Delete";
		}
	}
	public int getItemOption() {
		return itemOption;
	}
	public void setItemOption(int itemOption) {
		this.itemOption = itemOption;
	}
}
