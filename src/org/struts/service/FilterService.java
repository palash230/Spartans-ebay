package org.struts.service;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.Filtermodel;
import org.struts.utils.ConnectionPool;
public class FilterService {

	public void filtering( Filtermodel fsm) {
		ArrayList<Filtermodel> catModel=new ArrayList<Filtermodel>();
		Filtermodel tc=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		Statement stmt = ConnectionPool.con.createStatement();
		System.out.println("tcm.getItemSubCatId()  "+fsm.getCheckMe());
		System.out.println("tcm.getItemCatId()  "+fsm.getCheckMe1());
		String query="SELECT itemId,item_name,item_desc,cost,seller_id,image,imagePath FROM item where ItemCatId="+fsm.getCatId();
		if(!fsm.getCheckMe().equals("false"))
			query+=" and (cost < 500)";
		else if(!fsm.getCheckMe1().equals("false"))
			query+=" and (cost >=500 and cost <=1000)";
		else 
			query+=" and (cost >1000)";
		if(!fsm.getSubcatId().equals(""))
			query+=" and subCat_id = "+fsm.getSubcatId();
		query+=";";
		/*System.out.println(" query"+query+" ~~~tcm.getItemSubCatId()"+tcm.getItemSubCatId());*/
		ResultSet rs = stmt.executeQuery(query);
		fsm.setItemList(new ArrayList<Filtermodel>());
		while (rs.next()) {
			tc=new Filtermodel();
			tc.setItemId(rs.getString(1));
			tc.setItemName(rs.getString(2));
			tc.setItemDesc(rs.getString(3));
			tc.setCost(rs.getString(4));
			tc.setSeller_id(rs.getString(5));
			tc.setPhoto(rs.getBlob(6));
			tc.setImagePath(rs.getString(7));
			Blob pic=rs.getBlob(6);
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				tc.setBlobAsBytes(pic.getBytes(1, blobLength));
				tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
				}
			catModel.add(tc);
			}
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
		System.out.println("catModel.size() "+catModel.size());
		fsm.getItemList().addAll(catModel);
		System.out.println(" sizze is "+fsm.getItemList().size());

		
	}
	

}
