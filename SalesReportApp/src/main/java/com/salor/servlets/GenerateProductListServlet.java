package com.salor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

/**
 * Servlet implementation class GenerateProductListServlet
 */
@WebServlet("/generatepdtListurl")
public class GenerateProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Response Content Type
		response.setContentType("text/html");
		
		//Creating Session Object and get the userId from the session Object
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userid");
		
		//Creating Object of SalorService Class
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		
		//Calling the method of the Service Class for generating the Product List of the Organization
		String[] productList = salorService.productListService(userId);
		
		//Assigning the productList Array with the session object
		session.setAttribute("productList", productList);
		
		
		
		//Redirecting to the deleteProductSales.jsp page
		response.sendRedirect("delPdtSalesurl");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
