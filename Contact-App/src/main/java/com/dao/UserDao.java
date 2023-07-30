package com.dao;

import java.sql.*;

import com.entity.User;

public class UserDao {
	private Connection con;
	
	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean userRegister(User u) {
		boolean f = false;
		
		try {
			String query = "insert into UserData(id, name, email, password) values(?, ?, ?, ?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			
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
	
	public User loginUser(String email, String password) {
		User user = null;
		
		try {
			String query = "Select * from UserData where email = ? and password = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2,  password);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				user = new User();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setpassword(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
