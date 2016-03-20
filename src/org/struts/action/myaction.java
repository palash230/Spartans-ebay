package org.struts.action;

public class myaction {

	 private String catName;

	   public String execute() throws Exception {
		   System.out.println("helloe in myaction"+catName);
	      return "success";
	   }

	public String getUser() {
		return catName;
	}

	public void setUser(String catName) {
		this.catName = catName;
	}
	   
	   

}
