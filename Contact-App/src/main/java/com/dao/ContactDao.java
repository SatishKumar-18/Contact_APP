package com.dao;

import java.sql.*;
import java.util.*;

import com.entity.Contact;
public class ContactDao {
	private Connection con;
	
	public ContactDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveContact(Contact c) {
		boolean f = false;
		
		try {
			String query = "insert into contact(id, name, email, phone, userId) values (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, c.getId());
			pst.setString(2, c.getName());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getPhone());
			pst.setInt(5, c.getUserId());
			
			int n = pst.executeUpdate();
			
			if(n > 0) {
				f = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Contact> getAllContact(int userId){
		
		List<Contact> list = new ArrayList<>();
		Contact c = null;
		
		try {
			String query = "Select * from contact where userId=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, userId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				c = new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
				
				list.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Contact getContactById(int cid) {
		Contact c = new Contact();
		
		try{
			PreparedStatement pst = con.prepareStatement("Select * from contact where id=?");
			pst.setInt(1, cid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean updateContact(Contact c) {
		boolean f = false;
		
		try {
			String query = "update contact set name=?, email=?, phone=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, c.getName());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getPhone());
			pst.setInt(4, c.getId());
			
			int n = pst.executeUpdate();
			
			if(n > 0) {
				f = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteContact(int cid) {
		boolean f = false;
		
		try {
			String query = "delete from contact where id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, cid);
			
			int n = pst.executeUpdate();
			
			if(n==1) {
				f = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
