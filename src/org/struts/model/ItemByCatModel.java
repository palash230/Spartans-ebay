package org.struts.model;
import java.sql.Blob;
import java.util.ArrayList;
public class ItemByCatModel {
	private String itemCatId,itemSubCatId;
	private String itemId,itemName,itemDesc,cost,seller_id,imagePath,image64encode;
	private String catName,subCatName;
	private int quantity;
	private Blob photo;
	
	private byte[] blobAsBytes;
	private ArrayList<ItemByCatModel> itemList;
	private ArrayList<ItemByCatModel> itemList2;

	private String dealflag;
	private int discount;
	private String expiryOn;
	
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}


	public byte[] getBlobAsBytes() {
		return blobAsBytes;
	}

	public void setBlobAsBytes(byte[] blobAsBytes) {
		this.blobAsBytes = blobAsBytes;
	}

	public ArrayList<ItemByCatModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemByCatModel> itemList) {
		this.itemList = itemList;
	}

	public String getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(String itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getItemSubCatId() {
		return itemSubCatId;
	}

	public void setItemSubCatId(String itemSubCatId) {
		this.itemSubCatId = itemSubCatId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getImage64encode() {
		return image64encode;
	}

	public void setImage64encode(String image64encode) {
		this.image64encode = image64encode;
	}
	public String getDealFlag()
	{
		return dealflag;
	}
	public String isDealflag() {
		return dealflag;
	}

	public void setDealflag(String dealflag) {
		this.dealflag = dealflag;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getExpiryOn() {
		return expiryOn;
	}

	public void setExpiryOn(String expiryOn) {
		this.expiryOn = expiryOn;
	}

	public ArrayList<ItemByCatModel> getItemList2() {
		return itemList2;
	}

	public void setItemList2(ArrayList<ItemByCatModel> itemList2) {
		this.itemList2 = itemList2;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
