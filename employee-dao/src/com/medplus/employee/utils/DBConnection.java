package com.medplus.employee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.jdbc.Driver;

public class DBConnection {
	private static Connection conn;

	public static Connection open() {
		String url = "jdbc:mysql://localhost:3306/medplus";
		try {
//			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection(url, "root", "root");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
