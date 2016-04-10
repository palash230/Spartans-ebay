package org.struts.model;

import java.sql.Blob;

public class Test {
		private String itemCatId,itemSubCatId;
		private String itemId,itemName,itemDesc,seller_id,imagePath,image64encode;
		private String catName,subCatName;
	private int quantity,cost;
		private Blob photo;
		private byte[] blobAsBytes;
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
			//System.out.println("here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

	
}
