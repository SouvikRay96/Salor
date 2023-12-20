package com.salor.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the response type
		response.setContentType("text/html");
		
		//Getting the request from the Parameter
		String product = request.getParameter("productName");
		String[] temp = product.split("--");
		String productId = temp[0];
		String productName = temp[1];
		
		//Getting the userId from the Session Object
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userid");
		
		//Creating Service Layer Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		String status = salorService.deleteAllProductDetailsService(productId, userId);
		
		//Creating a message variable to display the appropriate message on deletion
		String deletemessage = null;
		
		//Checking successfull completion of the deletion of product
		if(status.equalsIgnoreCase("success")) {
			deletemessage = "Deletion of Product "+productName+" having the corresponding ProductID : "+productId+" is Successful";
		}
		else if(status.equalsIgnoreCase("failure")) {
			deletemessage = "Deletion of the Product "+productName+" is not Possible";
		}
		else {
			deletemessage = "Some Error Occured while Deleting the required Product";
		}
		session.setAttribute("deletemessage", deletemessage);
		RequestDispatcher rd = request.getRequestDispatcher("generatepdtListurl?opcode=del");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
