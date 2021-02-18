package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Connection con;
	        Statement stmt;
	        ResultSet rs;
	        
	        try {
	            //Register JDBC driver
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // open a connection
	            System.out.println("Connecting to database.....");
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mysqljdbc","root","Raju12345@");
	            
	           //creting statement object
	            stmt=con.createStatement();
	            
	            // execute a query
	            rs=stmt.executeQuery("select c.id,first_name,name from candidates c inner join candidate_skills cs on c.id=cs.candidate_id  inner join skills s on cs.skill_id=s.id");
	            while(rs.next()) {
	            	System.out.println(rs.getInt(1)+" "+rs.getString(2)+"      "+rs.getString(3));
	            }
	        }
	        
	        catch(Exception e) {
	        	System.out.println(e);
	        }

	}

}
