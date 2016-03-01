package org.struts.model;
import java.util.*;
class Item
{
	private String itemId;
	private ArrayList<String> itemName; 
	Item(String itemId,ArrayList<String> itemName)
	{
		this.itemId=itemId;
		this.itemName=itemName;
	}

	public ArrayList<String> getItemName() {
		return itemName;
	}
	public void setItemName(ArrayList<String> itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
public class CallModel{
	private ArrayList<Item> itemIdList1;
	private ArrayList<String> itemName;
	
	public ArrayList<Item> getItemIdList1() {
		return itemIdList1;
	}
	
	public void setItemIdList1(ArrayList<Item> itemIdList1) {
		this.itemIdList1 = itemIdList1;
	}
	public void addItemIdList(String itemId,ArrayList<String> itemName) {
		Item it=new Item(itemId,itemName);
		if(itemIdList1==null)
			{
			itemIdList1=new ArrayList<Item>();
			}
		this.itemIdList1.add(it);
	}
	

	public ArrayList<String> getItemName() {
		return itemName;
	}

	public void setItemName(ArrayList<String> itemName) {
		this.itemName = itemName;
	}
	 	 
}
