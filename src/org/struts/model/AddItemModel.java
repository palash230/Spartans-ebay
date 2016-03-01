package org.struts.model;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
//import org.struts.model.*;
//import org.struts.utils.ConnectionPool;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
public class AddItemModel {
	private String itemId,itemName,itemDesc,picPath,test,item;
	private String sellerId,advCheck,catName,subCatName,addField1,addField2;
	private int price;
	private File pic;
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
public String getSubCatName() {
	return subCatName;
}
public void setSubCatName(String subCatName) {
	this.subCatName = subCatName;
}
public String getCatName() {
	return catName;
}
public void setCatName(String catName) {
	this.catName = catName;
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
}
