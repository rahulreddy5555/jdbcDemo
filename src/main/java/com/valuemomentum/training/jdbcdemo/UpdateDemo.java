package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

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
            
           String sqlUpdate="update candidates set last_name=? where id=?";
           PreparedStatement p=con.prepareStatement(sqlUpdate);
           Scanner obj =new Scanner(System.in);
           System.out.println("enter lastname to be updated and id");
           String ud=obj.nextLine();
           int id=obj.nextInt();
           p.setString(1, ud);
           p.setInt(2, id);
           int rowseffected=p.executeUpdate();
            System.out.println(String.format("Rows affected %d", rowseffected));
            
            //reuse prepared statement
            ud = "grohe";
            id=101;
            p.setString(1, ud);
            p.setInt(2, id);
            rowseffected=p.executeUpdate();
            System.out.println(String.format("rows affected %d",rowseffected));
            
        }
        
        catch(Exception e) {
        	System.out.println(e);
        }

	}

}
