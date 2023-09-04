package com.salor.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int noshops = Integer.parseInt(request.getParameter("noshops"));
		String orgSize = request.getParameter("orgsize");
		String ownerName = request.getParameter("ownername");
		String pwd = request.getParameter("password");
		String cnfpwd = request.getParameter("cnfpassword");
		
		//Creating SalorService Class Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		//Defining UserId variable
		String userId = null;
		int min = 100,max = 1000;
		Random rand = new Random();
		int id = rand.nextInt(max-min+1)+min;
		userId = "ORG"+id;
		int flag = 0;
		do {
			String status = salorService.checkUserIdService(userId);
			
		}while(flag == 0);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
