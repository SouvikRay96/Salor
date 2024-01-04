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
 * Servlet implementation class ViewSalesReportServlet
 */
@WebServlet("/viewsalesreportservlet")
public class ViewSalesReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type
		response.setContentType("text/html");
		
		//Getting the userid from the Session Object
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		
		//Retrieving Product from the user submitted form
		String product = request.getParameter("productName");
		String opcode = request.getParameter("opcode");
		
		//Getting the productId
		String[] temp = product.split("--");
		String productId = temp[0];
		String productName = temp[1];
		
		//Creating Service Layer Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		SalorProductBean[] productsales = salorService.visualizeReportService(productId, userid);
		
		//Setting the Attribute productsales of the session Object
		session.setAttribute("productsales", productsales);
		session.setAttribute("productName", productName);
		session.setAttribute("productId", productId);
		
		//Declaring an url variable to redirect the page based on the request
		String url = null;
		if(opcode.equalsIgnoreCase("view"))
			url = "salesreport";
		else if(opcode.equalsIgnoreCase("modify"))
			url = "updateDeleteSales";
		response.sendRedirect(url);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
