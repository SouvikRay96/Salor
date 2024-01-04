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
 * Servlet implementation class FilterSalesReportServlet
 */
@WebServlet("/filtersalesreport")
public class FilterSalesReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the ContentType for the page
		response.setContentType("text/html");
		
		//Retrieving values from the filtration form
		String dateBought = request.getParameter("dateBought");
		String monthBought = request.getParameter("monthBought");
		String yearBought = request.getParameter("yearBought");
		String dateSold = request.getParameter("dateSold");
		String monthSold = request.getParameter("monthSold");
		String yearSold = request.getParameter("yearSold");
		
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String boughtMonthNo = null,soldMonthNo = null;
		
		for(int i = 0; i<12; i++) {
			if(months[i].equalsIgnoreCase(monthBought)) {
				boughtMonthNo = Integer.toString(i+1);
			}
			if(months[i].equalsIgnoreCase(monthSold)) {
				soldMonthNo = Integer.toString(i+1);
			}
		}
		
		String boughtDate = yearBought + "-" + boughtMonthNo + "-" + dateBought;
		String soldDate = yearSold + "-" + soldMonthNo + "-" + dateSold;
		
		
		//Getting the UserId and ProductId from the Session Object
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userid");
		String productId = (String)session.getAttribute("productId");
		
		//Creating Service Layer Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		
		//Calling the Service Class Filter Method
		SalorProductBean[] productsales = salorService.filterSalesReportService(userId, productId, boughtDate, soldDate);
		
		//Creating a message for displaying which records are visible
		String filterMessage = null;
		if(productsales == null)
			filterMessage = "There is no records between Date_Bought "+boughtDate+" and Date_Sold "+soldDate;
		else
			filterMessage = "The Sales Records of the Above Prroduct between Date_Bought "+boughtDate+" and Date_Sold "+soldDate+" are as follows";
		
		//Setting the productsales Attribute of the Session Object
		session.setAttribute("productsales", productsales);
		session.setAttribute("filterMessage", filterMessage);
		response.sendRedirect("salesreport");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
