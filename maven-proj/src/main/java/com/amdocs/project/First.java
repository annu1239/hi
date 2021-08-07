package com.amdocs.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class First {
	
	public static String driver = "com.mysql.cj.jdbc.Driver";	
	public static String url = "jdbc:mysql://localhost:3306/db";
	public static String username = "root";
	public static String password = "Asdf@2134";
	
	public static void readAdmin() {
		// TODO Auto-generated method stub
		
		try {	
				Class.forName(driver);
				
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM USER";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt("ID");
					String name = rs.getString("USERNAME");
					String email = rs.getString("EMAIL");
					String password = rs.getString("PASSWORD");
					
					System.out.println("ID : " + id + " Username : " + username + " EMAIL : " + email + " PASSWORD : " + password);
					
				}
				
				}
			
				catch(Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	public static void main(String[] args) {		
		
		readAdmin();

}
	}
