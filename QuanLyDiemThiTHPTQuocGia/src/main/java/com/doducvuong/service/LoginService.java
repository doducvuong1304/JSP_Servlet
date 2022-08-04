package com.doducvuong.service;

import java.util.List;
import java.util.Objects;

import com.doducvuong.model.Account;
import com.doducvuong.dao.AccountDAO;

public class LoginService {
	
	/**
	 * method: check if account is available in database by username, password
	 * @param username
	 * @param password
	 * @return true if account is available, false if account is not available
	 */
	public static boolean checkIfAccountIsValid (String username, String password) {
		AccountDAO accountDAO = new AccountDAO();
		List<Account> accounts = accountDAO.findAccountByUsernameAndPassword(username, password);
		
		if (Objects.isNull(accounts) || accounts.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
