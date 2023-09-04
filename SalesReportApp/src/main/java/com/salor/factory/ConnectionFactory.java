package com.salor.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salor", "root", "tojosoumili12");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnectionObject() {
		return con;
	}
}
