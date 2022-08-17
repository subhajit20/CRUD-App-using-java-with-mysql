package com.crud.db;
import java.sql.*;

public class MyDB {
	public Connection connection;
	public  MyDB(){
		try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sys",
                "Subhajit", "SUBHAJIT");
            System.out.println("Database is Connected.....");
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
	}
}
