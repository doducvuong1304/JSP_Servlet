package com.doducvuong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doducvuong.service.LoginService;
import com.doducvuong.util.Constant;
import com.doducvuong.util.Util;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hide Error Message
		request.setAttribute("loginErrorMessage", "");
		// forward to login.jsp
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get input value of user
		String username = request.getParameter("username-text");
		String password = request.getParameter("password-text");
		
		// if user fill full 2 fields
		if (Util.checkIfStringIsNotNullOrEmpty(username) && Util.checkIfStringIsNotNullOrEmpty(password)) {
			boolean accountIsValid = LoginService.checkIfAccountIsValid(username, password);
			
			// if account valid
			if (accountIsValid) {
				request.getSession().setAttribute("usernameLoggedIn", username);
				request.getSession().setAttribute("passwordLoggedIn", password);
				response.sendRedirect(request.getContextPath() + "/HomeController");
				return;
			// if account invalid
			} else {
				request.setAttribute("loginErrorMessage", Constant.ERROR_LOGIN_INFORMATION);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		// if user missing any field
		} else {
			request.setAttribute("loginErrorMessage", Constant.ERROR_FILL_INFORMATION);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
