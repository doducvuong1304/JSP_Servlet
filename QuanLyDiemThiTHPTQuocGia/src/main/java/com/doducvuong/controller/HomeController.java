package com.doducvuong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doducvuong.util.Constant;
import com.doducvuong.util.Util;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hide Error Message
		request.setAttribute("homeErrorMessage", "");
		// forward to home.jsp
		request.getRequestDispatcher("home.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get input number value of user
		String number = request.getParameter("number-text");
		
		// if user input valid
		if (Util.checkIfStringIsNotNullOrEmpty(number) && Util.isIntegerNumberLargeThanZero(number)) {
			request.getSession().setAttribute("numberInputed", number);
			response.sendRedirect(request.getContextPath() + "/DetailController");
			return;
		// if user input invalid
		} else {
			request.setAttribute("homeErrorMessage", Constant.ERROR_NUMBER_INPUT);
			request.getRequestDispatcher("home.jsp").forward(request, response);
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
