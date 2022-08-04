package com.doducvuong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.doducvuong.model.Account;
import com.doducvuong.connection.MySQLConnection;

public class AccountDAO {
	
	/**
	 * method: find account by username and password
	 * @param username
	 * @param password
	 * @return list of account if success, null if not found
	 */
	public List<Account> findAccountByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		List<Account> accounts = new ArrayList<Account>();
		
		try {
			connection = MySQLConnection.getDatabaseConnection();
			String query = "select * from account where username = ? and password = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String usernameGetFromDB = resultSet.getString("username");
				String passwordGetFromDB = resultSet.getString("password");
				
				Account account = new Account();
				account.setUsername(usernameGetFromDB);
				account.setPassword(passwordGetFromDB);
				accounts.add(account);
			}
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
		} catch (Exception e) {
				e.getMessage();
			}
		}
		
	}

}