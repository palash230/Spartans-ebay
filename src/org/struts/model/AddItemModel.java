package org.struts.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
//import org.struts.model.*;
//import org.struts.utils.ConnectionPool;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
public class AddItemModel {
	private String itemId,itemName,itemDesc,picPath,test,item;
	private String sellerId,advCheck,categoryId,subCatId,addField1,addField2;
	private int price;
	private String categoryName;
	private ArrayList<String> colorItem;
	private String startDate;
	private String adv_Cost;
	private String endDate;
	public AddItemModel(){
		 
		colorItem = new ArrayList<String>();
		colorItem.add("red");
		colorItem.add("black");
		colorItem.add("blue");
		colorItem.add("white");
		colorItem.add("others");
		} 
	public ArrayList<String> getColorItem() {
		return colorItem;
	}
	public void setColorItem(ArrayList<String> colorItem) {
		this.colorItem = colorItem;
	}
	private ArrayList<CategoryModel> categoryList; 
	//private ArrayList<SubCatModel> subCatList;
	private Map<String,String> subCatList;
	private File pic;
	private String expireOn,dealFlag;
	private int discount;
	private int quantity;
	private String warranty,color,weight,brand,condition;
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getItemDesc() {
	return itemDesc;
}
public void setItemDesc(String itemDesc) {
	this.itemDesc = itemDesc;
}
public String getPicPath() {
	return picPath;
}
public void setPicPath(String picPath) {
	
	this.picPath = picPath;  
}
public String getAddField2() {
	return addField2;
}
public void setAddField2(String addField2) {
	this.addField2 = addField2;
}
public String getAddField1() {
	return addField1;
}
public void setAddField1(String addField1) {
	this.addField1 = addField1;
}
public String getAdvCheck() {
	return advCheck;
}
public void setAdvCheck(String advCheck) {
	this.advCheck = advCheck;
}
public String getSellerId() {
	return sellerId;
}
public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public File getPic() {
	return pic;
}
public void setPic(File pic) {

		 this.pic=pic;
		 System.out.println("pic.getAbsolutePath()->"+pic.getAbsolutePath());
		 System.out.println("pic.getAbsolutePath()->"+pic.getPath());
}
public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getSubCatId() {
	return subCatId;
}
public void setSubCatId(String subCatId) {
	this.subCatId = subCatId;
}
public ArrayList<CategoryModel> getCategoryList() {
	return categoryList;
}
public void setCategoryList(ArrayList<CategoryModel> categoryList) {
	this.categoryList = categoryList;
}
public Map<String,String> getSubCatList() {
	return subCatList;
}
public void setSubCatList(Map<String,String> subCatList) {
	this.subCatList = subCatList;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public void addCategoryList(String categoryId,String categoryName)
{
	if(categoryList==null)
		categoryList=new ArrayList<CategoryModel>();
	if(subCatList==null)
		subCatList=new HashMap<String,String>();
	CategoryModel cm=new CategoryModel(categoryId,categoryName,null);
	categoryList.add(cm);
}

public String getExpireOn() {
	return expireOn;
}
public void setExpireOn(String expireOn) {
	this.expireOn = expireOn;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public String getDealFlag() {
	return dealFlag;
}
public void setDealFlag(String dealFlag) {
	this.dealFlag = dealFlag;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getWarranty() {
	return warranty;
}
public void setWarranty(String warranty) {
	this.warranty = warranty;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCondition() {
	return condition;
}
public void setCondition(String condition) {
	this.condition = condition;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getAdv_Cost() {
	return adv_Cost;
}
public void setAdv_Cost(String adv_Cost) {
	this.adv_Cost = adv_Cost;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
}
