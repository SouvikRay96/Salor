package com.salor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.bean.SalorProductBean;
import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

/**
 * Servlet implementation class FetchUpdatedRecords
 */
@WebServlet("/FetchUpdatedRecords")
public class FetchUpdatedRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the response type
		response.setContentType("text/html");
		
		//Getting the productId and the userid from the session object
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		String productId = (String)session.getAttribute("productId");
		
		//Creating Service Layer Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		SalorProductBean[] productsales = salorService.visualizeReportService(productId, userid);
		
		//Setting the Attribute productsales of the session Object
		session.setAttribute("productsales", productsales);
		
		response.sendRedirect("updateDeleteSales");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
