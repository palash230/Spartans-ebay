package org.struts.service;

import java.sql.Blob;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.ItemByCatModel;
import org.struts.utils.ConnectionPool;

public class ItemByCatService {
		public void modelInitialization(ItemByCatModel tcm)
		{
			ArrayList<ItemByCatModel> catModel=new ArrayList<ItemByCatModel>();
			ItemByCatModel tc=null;
			try
			{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			Statement stmt = ConnectionPool.con.createStatement();
			System.out.println("tcm.getItemSubCatId()  "+tcm.getItemSubCatId() );
			System.out.println("tcm.getItemCatId()  "+tcm.getItemCatId());
			String query="SELECT itemId,item_name,item_desc,price069,seller_id,image,imagePath FROM item069 where itemCatId="+tcm.getItemCatId();
			if(!tcm.getItemSubCatId().equals(""))
				query+=" and subCat_id = "+tcm.getItemSubCatId();
			query+=";";
			System.out.println(" query"+query+" ~~~tcm.getItemSubCatId()"+tcm.getItemSubCatId());
			ResultSet rs = stmt.executeQuery(query);
			tcm.setItemList(new ArrayList<ItemByCatModel>());
			while (rs.next()) {
				tc=new ItemByCatModel();
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
			tcm.getItemList().addAll(catModel);
			System.out.println(" sizze is "+tcm.getItemList().size());
	}
}


