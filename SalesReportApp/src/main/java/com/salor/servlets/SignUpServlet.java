package com.salor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting Response type of the page
		response.setContentType("text/html");
		
		//Retrieving Form data from the user
		String orgName = request.getParameter("orgname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int noshops = Integer.parseInt(request.getParameter("noshops"));
		String orgSize = request.getParameter("orgsize");
		String ownerName = request.getParameter("ownername");
		String pwd = request.getParameter("password");
		String cnfpwd = request.getParameter("cnfpassword");
		
		//Defining UserId variable
		String userId = null;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
