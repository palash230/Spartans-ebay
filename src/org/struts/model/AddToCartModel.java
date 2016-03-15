package org.struts.model;

import java.sql.Blob;
import java.util.ArrayList;

public class AddToCartModel {

	private ArrayList<Test> itemList;
	private String itemId,SellerId;
	private int total_cost,cost;
	
	public ArrayList<Test> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Test> itemList) {
		this.itemList = itemList;
	}

	
	public void addItemIdList(ArrayList<Test> t) {
	//	Item it=new Item(itemId,itemName);
		if(itemList==null)
			{
		itemList=new ArrayList<Test>();
			}
		this.itemList.addAll(t);
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSellerId() {
		return SellerId;
	}

	public void setSellerId(String sellerId) {
		SellerId = sellerId;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
}
