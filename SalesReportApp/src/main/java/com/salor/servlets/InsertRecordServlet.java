package com.salor.servlets;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class InsertRecordServlet
 */
@WebServlet("/insertRecordurl")
public class InsertRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Response Content Type
		response.setContentType("text/html");
		
		//Retrieving Form Data
		String productName = request.getParameter("pdtname");
		
		
		//Getting the UserId of the Organization from the session Object
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		//Creating the SalorService Class Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		String insertmessage = null;
		
		//Checking the product to be inserted is already present in the Organization's Database or not
		String duplicateCheck = salorService.duplicateProductService(productName, userid);
		if(duplicateCheck.equalsIgnoreCase("duplicate")) {
			insertmessage = "Duplicate Product Cannot be Inserted ... Product Already present in the Organization's database";
		}
		else if(duplicateCheck.equalsIgnoreCase("error")) {
			insertmessage = "Some Error Occured ... Sorry !!! Please Try Again";
		}
		else {
			//Generating the ProductId
			String productId = null;
			int min = 100,max = 10000;
			Random rand = new Random();
			int id = rand.nextInt(max-min + 1)+min,flag = 0;
			productId = "PDT" + id;
			do {
				String check = salorService.checkProductIdService(productId,userid);
				if(check.equalsIgnoreCase("success"))
					flag = 1;
				else {
					id = rand.nextInt(max-min + 1)+min;
					productId = "PDT" + id;
				}
			}while(flag == 0);
			
			//System.out.println("The ProductId is  : "+productId);
			
			
			//Creating SalorProductBean Class Object
			SalorProductBean salorPdt = new SalorProductBean();
			
			//Setting the object attributes with the form data values
			salorPdt.setProductId(productId);
			salorPdt.setProductName(productName);
			
			
			//Sending the salor Product Object to the Service class
			String status = salorService.insertProductService(salorPdt,userid);
			if(status.equalsIgnoreCase("success")) {
				insertmessage = "Product Name Inserted Successfully";
			}
			else if(status.equalsIgnoreCase("failure")) {
				insertmessage = "Product Name Cannot be Inserted";
			}
			else {
				insertmessage = "Some Error Occured while inserting the Product into the database";
			}
		}
		
		session.setAttribute("insertmessage", insertmessage);
		response.sendRedirect("insertpdturl");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
