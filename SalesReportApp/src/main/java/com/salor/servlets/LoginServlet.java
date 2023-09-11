package com.salor.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.bean.SalorAccountLogin;
import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SalorServiceInterface salorService;
	
	@Override
	public void init() throws ServletException {
		salorService = SalorServiceFactory.getSalorServiceObject();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type of the Page
		response.setContentType("text/html");
		//Declaring message variable to store the relevant message at Login
		String message = null;
		//Retrieving data from the form
		String orgName = request.getParameter("orgname");
		String email = request.getParameter("emailid");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//Calling the Service Class Method
		String status = salorService.loginAccountService(new SalorAccountLogin(orgName, email, userid, pwd));
		
		//Now Checking the Login Status
		if(status == null) {
			message = "OOP's !!! Something Went Wrong";
		}
		if(status.equalsIgnoreCase("success")){
			message = "Login Successfull";
			HttpSession session = request.getSession();
			session.setAttribute("message", message);
			response.sendRedirect("homepage");
		}
		else {
			if(status.equalsIgnoreCase("orgNameMismatch")) {
				message = "Please Provide a Correct Organization Name";
			}
			else if(status.equalsIgnoreCase("emailMismatch")) {
				message = "Please Provide a Valid Email-ID";
			}
			else if(status.equalsIgnoreCase("passwordMismatch")) {
				message = "Please Provide a Correct Password";
			}
			else if(status.equalsIgnoreCase("failure")) {
				message = "User-ID didn't matched";
			}
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("loginpage");
			rd.forward(request, response);
			
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
