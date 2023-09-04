package com.salor.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.bean.SalorAccountsRegister;
import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

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
		//int noshops = Integer.parseInt(request.getParameter("noshops"));
		String orgSize = request.getParameter("orgsize");
		String ownerName = request.getParameter("ownername");
		String pwd = request.getParameter("password");
		String cnfpwd = request.getParameter("cnfpassword");
		
		//Creating SalorService Class Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		//Defining UserId variable
		String userId = null;
		//Generating the User ID which is unique for each Organization
		int min = 100,max = 1000;
		Random rand = new Random();
		int id = rand.nextInt(max-min+1)+min;
		userId = "ORG"+id;
		int flag = 0;
		do {
			String status = salorService.checkUserIdService(userId);
			if(status.equalsIgnoreCase("success")) {
				flag = 1;
				break;
			}
			else {
				id = rand.nextInt(max-min+1)+min;
				userId = "ORG"+id;
				flag = 0;
			}
		}while(flag == 0);
		
		//Creating User account Object for Registration
		SalorAccountsRegister accReg = new SalorAccountsRegister(userId, orgName, email, address, orgSize, ownerName, pwd);
		
		//Creating Session Object for Session Management
		HttpSession session = request.getSession();
		
		//Calling the service method to register the account
		String status = salorService.registerAccountService(accReg);
		if(status.equalsIgnoreCase("success")) {
			session.setAttribute("userId", userId);
			response.sendRedirect("loginpage");
		}
		else {
			session.setAttribute("errorMessage", "Some Problem Occured during Registration of the Account.");
			response.sendRedirect("register");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
