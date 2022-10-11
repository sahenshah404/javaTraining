package com.medplus.insurance.policy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	private static Connection conn = null;

	public static Connection connect() {
		String url = "jdbc:mysql://localhost:3306/insurance";

		try {
			DriverManager.registerDriver(new Driver());
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
