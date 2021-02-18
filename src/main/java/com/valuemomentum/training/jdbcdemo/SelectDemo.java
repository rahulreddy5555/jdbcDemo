package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		 Connection con;
	        Statement s;
	        ResultSet rs;
	        
	        try {
	            //Register JDBC driver
	           
	        	
	        	//Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // open a connection
	            
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mysqljdbc","root","Raju12345@");
	            
	           //creating statement object
	            s=con.createStatement();
	            
	            // execute a query
	            rs=s.executeQuery("select * from candidates");
	            
	            //Extract data from result set
	            while(rs.next()) {
	                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+
	                    "  "+rs.getDate(4)+"  "+rs.getString(5)+"  "+rs.getString(6));
	                
	                
	            }
	            rs.close();
	            s.close();
	            con.close();
	            
	                
	        }
	        catch(Exception e) {
	            System.out.println(e);}

	}

}
