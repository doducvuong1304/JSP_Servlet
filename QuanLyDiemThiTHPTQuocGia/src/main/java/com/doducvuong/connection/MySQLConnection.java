package com.doducvuong.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.doducvuong.util.Constant;

public class MySQLConnection {

	private static String DRIVER_URL = "com.mysql.cj.jdbc.Driver";

	private static String DRIVER = "jdbc:mysql://";

	private static String HOST = "localhost:";

	private static int PORT = 3306;

	private static String BACKWARD = "/";

	private static String DB_NAME = "login_demo";

	private static String USER_NAME = "root";

	private static String USER_PASS = "Aa@123456";
	
	/**
	 * method: get database connection 
	 * @return null if fail
	 * @throws ClassNotFoundException
	 */
	public static Connection getDatabaseConnection() throws ClassNotFoundException {
		Class.forName(DRIVER_URL);
		try {
			System.out.println(Constant.NOTIFY_DATABASECONNECTION_SUCCESS);
			return DriverManager.getConnection(DRIVER + HOST + PORT + BACKWARD + DB_NAME, USER_NAME, USER_PASS);
		} catch (SQLException e) {
			System.out.println(Constant.ERROR_DATABASECONNECTION_FAIL);
			e.printStackTrace();
		}
		return null;
	}

}