package com.crud.crudfunctions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.crud.db.*;

public class CrudFunction {
	MyDB db = new MyDB();
	
	public void Create(int myId,String myName){
		try{
			String query = String.format("INSERT INTO CRUD VALUES (%d,'%s')",myId,myName);
			PreparedStatement st = db.connection.prepareStatement(query);
			st.execute();
			System.out.println("Successfully inserted data :)");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void  Read(){
		ResultSet pr;
		Statement st;
		try{
			st = db.connection.createStatement();
			pr = st.executeQuery("SELECT * FROM crud");
			System.out.print("Id \t\t");
			System.out.println("Name");
			while(pr.next()){
				System.out.print(pr.getInt("id")+"\t\t");
				System.out.println(pr.getString("name"));
			}
			System.out.println("\n\n\n");
		}catch(Exception e){
			System.out.println("Table is empty");
		}
	}
	
	public void Update(int id,String new_name){
		Statement st;
		try{
			st = db.connection.createStatement();
			String qr = String.format("UPDATE crud set name='%s' where id=%d",new_name,id);
			int isUpdated = st.executeUpdate(qr);
			
			if(isUpdated == 1){
				System.out.println("RECORD UPDATED SUCCESSFULLY...");
			}else if(isUpdated == 0){
				System.out.println("RECORD IS NOT FOUND !!");
			}
			
			System.out.println("\n");
		}catch(Exception e){
			System.out.println("Record is not found");
		}
	}
	
	public void Delete(int id){
		Statement st;
		try{
			st = db.connection.createStatement();
			String qr = String.format("DELETE FROM crud where id=%d",id);
			int isDelete = st.executeUpdate(qr);
			
			if(isDelete == 1){
				System.out.println("RECORD DELETED SUCCESSFULLY...");
			}else if(isDelete == 0){
				System.out.println("RECORD IS NOT FOUND !!");
			}
			System.out.println("\n");
		}catch(Exception e){
			System.out.println("Record is not found!! DELETE NOT POSSIBLE");
		}
	}
}
