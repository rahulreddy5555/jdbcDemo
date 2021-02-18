package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {

	public static void main(String[] args) {
		 Connection con;
	        Statement stmt;
	        ResultSet rs;
	        
	        try {
	            //Register JDBC driver
	           
	        	
	        	//Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // open a connection
	            
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mysqljdbc","root","Raju12345@");
	            
	            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            rs=stmt.executeQuery("select * from skills");
	            rs.afterLast();
	            while(rs.previous()) {
	            	System.out.println(rs.getInt(1)+"   "+rs.getString(2));
	            	
	            }
	            System.out.println("**********************************");
	            
	            //move cursor to third record
	            rs.absolute(3);
	            System.out.println(rs.getInt(1)+"   "+rs.getString(2));
	            
	            System.out.println("*******************8*****************");
	            
	            //move the cursor to secong record 
	            rs.relative(-1);
	            System.out.println(rs.getInt(1)+"   "+rs.getString(2));
	            System.out.println("************************************");
	            int i=rs.getRow();
	            System.out.println("cursor position "+i);
	            
	            rs.close();
	            stmt.close();
	            con.close();
	
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
}}
