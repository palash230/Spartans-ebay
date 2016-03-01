package org.struts.model;

import java.util.ArrayList;
import java.util.Map;

public class SubCatModel
{
	private String catName;
	private String catId;
	private ArrayList<Map<String,String>> subCat;
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public ArrayList<Map<String,String>> getSubCat() {
		return subCat;
	}
	public void setSubCat(ArrayList<Map<String,String>> subCat) {
		this.subCat = subCat;
	}
}