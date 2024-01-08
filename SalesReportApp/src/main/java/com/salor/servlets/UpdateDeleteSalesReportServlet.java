package com.salor.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UpdateDeleteSalesReportServlet
 */
@WebServlet("/updatedeletesalesreportservlet")
public class UpdateDeleteSalesReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type of the Page
		response.setContentType("text/html");
		
		String operation = request.getParameter("operation");
		int recordno = Integer.parseInt(request.getParameter("recordno"));
		
		//Getting the ProductId and the UserId from the Session Object
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		String productId = (String)session.getAttribute("productId");
		
		//Setting the recordno and ProductId for the Product's Sales to be deleted
		SalorProductBean product = new SalorProductBean();
		product.setProductId(productId);;
		product.setRecordno(recordno);
		
		//Declaring two String variable url and deleteMessage
		//url variable will have the url of the page on which to redirect
		//And deleteMessage variable will have the appropriate message on deletion of the sales record of the product
		String url = null,deleteSalesMessage = null;
		
		//Creating Service layer Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		
		if(operation.equalsIgnoreCase("update")) {
			//Redirecting to the update form page by getting all the previous sales record of the product
			//First fetch the product based on the record no
			SalorProductBean productSales = salorService.fetchProductService(recordno,userid,productId);
			session.setAttribute("productToUpdate", productSales);
			url = "updatedInfo";
		}
		else if(operation.equalsIgnoreCase("delete")){
			//Deleting the selected Sales Record
			String status = salorService.deleteProductService(product,userid);
			if(status.equalsIgnoreCase("success")) {
				deleteSalesMessage = "Product Sale's Record Deleted Successfully";
			}
			else if(status.equalsIgnoreCase("failure")) {
				deleteSalesMessage = "Deletion of the Sale's Record of the Product is not Possible";
			}
			else if(status.equalsIgnoreCase("error")) {
				deleteSalesMessage = "Some Error Occured while deletion of the Product's Sales Record";
			}
			SalorProductBean[] salesReport = salorService.visualizeReportService(productId, userid);
			session.setAttribute("productsales", salesReport);
			url = "updateDeleteSales";
		}
		
		request.setAttribute("deleteSalesMessage", deleteSalesMessage);
		RequestDispatcher rd = request.getRequestDispatcher(url);
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
