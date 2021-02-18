package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		  Connection con;
	        Statement stmt;
	        ResultSet rs;
	        int cnt=0;
	        
	        try {
	            //Register JDBC driver
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // open a connection
	            System.out.println("Connecting to database.....");
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mysqljdbc","root","Raju12345@");
	            
	           //creting statement object
	            stmt=con.createStatement();
	            String str="insert into skills(name) values('hybernet')";
	            
	            // execute a query
	            int rowcount=stmt.executeUpdate(str);
	            while(rowcount>0) {
	            	System.out.println("sucessfully updated details");
	            	 break;
	            }
	            rs=stmt.executeQuery("select count(id) from skills");
	            while(rs.next()) {
	            	cnt=rs.getInt(1);
	            	
	            }
	            System.out.println("total records are  "+cnt);
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }

	}

}
