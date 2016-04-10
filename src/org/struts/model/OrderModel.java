package org.struts.model;

import java.util.ArrayList;

import org.struts.action.Rating;

public class OrderModel {
	private String orderId,userId,itemId,image64encode,st;
	private String sellerId,quantity,status,orderDate,paymentId,orderFlag,price,address;
	private String itemDesc,sellerName,itemName;
	private ArrayList<String> statusList;
	private ArrayList<OrderModel> orderList;
	public String getOrderId() {
		return orderId;
	}
	int rating;
	public int getRating() {
		return rating;
	}
	public void setRating() {
		this.rating = Rating.getRating();
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<OrderModel> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<OrderModel> orderList) {
		this.orderList = orderList;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getImage64encode() {
		return image64encode;
	}
	public void setImage64encode(String image64encode) {
		this.image64encode = image64encode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public ArrayList<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(ArrayList<String> statusList) {
		this.statusList = statusList;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}

}
