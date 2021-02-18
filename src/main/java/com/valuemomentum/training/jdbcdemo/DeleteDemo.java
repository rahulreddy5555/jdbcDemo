package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		  Connection con;
	        Statement stmt;
	        ResultSet rs;
	        int cnt;
	        
	        try {
	          
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	         
	            System.out.println("Connecting to database.....");
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mysqljdbc","root","Raju12345@");
	            
	           //creting statement object
	            stmt=con.createStatement();
	            String q="Delete from candidates where rtrim(last_name) like\'L%g\';";
	            System.out.println(" ");
	            // execute a query
	           cnt =stmt.executeUpdate(q);
	            if(cnt>0) {
	            	System.out.println("Leong daleted succesfully");
	            }
	            else {
	            	System.out.println("record not found");
	            }
	            con.close();
		        //rs.close();
	        }
	      
	            catch(Exception e) {
	            	System.out.println(e);
	            }
	}

}
