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
 * Servlet implementation class UpdateSalesReport
 */
@WebServlet("/updatesalesreport")
public class UpdateSalesReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type for the Page
		response.setContentType("text/html");
		
		//Getting the userId from the Session Object
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userid");
		String productId = (String)session.getAttribute("productId");
		
		SalorProductBean sales = (SalorProductBean)session.getAttribute("productToUpdate");
		//Getting the recordno
		int recordno = sales.getRecordno();
		
		//Retrieving the form data
		double productcp = Double.parseDouble(request.getParameter("productcp"));
		double productsp = Double.parseDouble(request.getParameter("productsp"));
		int quantityManufactured = Integer.parseInt(request.getParameter("quantityManufactured"));
		int quantitySold = Integer.parseInt(request.getParameter("quantitySold"));
		String dateBought = request.getParameter("dateBought");
		String monthBought = request.getParameter("monthBought");
		String yearBought = request.getParameter("yearBought");
		String dateSold = request.getParameter("dateSold");
		String monthSold = request.getParameter("monthSold");
		String yearSold = request.getParameter("yearSold");
		
		double totalCost = productcp * quantityManufactured;
		double totalSales = productsp * quantitySold;
		
		//Calculating the month number of both the months
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
		
		//Calculating Total Profit and Total Loss Percentage
		double netProfit=0.0,netLoss=0.0,t;
		t = totalSales - totalCost;
		if(t > 0) {
			netProfit = (t/totalCost) * 100;
			netLoss = 0;
		}
		else if(t < 0 ) {
			t = totalCost-totalSales;
			netLoss = (t/totalCost) * 100;
			netProfit = 0;
		}
		else {
			netProfit=0.0;netLoss=0.0;
		}
		

		//Creating the SalorProductBean Class Object
		SalorProductBean salorpdt = new SalorProductBean();
		
		//Setting the values of the SalorProduct Bean Class
		salorpdt.setRecordno(recordno);
		salorpdt.setProductId(productId);
		salorpdt.setCostPerProduct(productcp);
		salorpdt.setSpPerProduct(productsp);
		salorpdt.setQuantityManufactured(quantityManufactured);
		salorpdt.setQuantitySold(quantitySold);
		salorpdt.setTotalCostOfProduction(totalCost);
		salorpdt.setTotalSales(totalSales);
		salorpdt.setNetProfit(netProfit);
		salorpdt.setNetLoss(netLoss);
		salorpdt.setDateBought(boughtDate);
		salorpdt.setDateSold(soldDate);
		
		//Creating the Object of the SalorService Class
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		
		//Declaring an UpdateMessage variable to display relevant message after update operation
		String updateMessage = null;
		String status = salorService.updateProductService(salorpdt,userId);
		if(status.equalsIgnoreCase("success")) {
			updateMessage = "The Sales record has been updated Successfully";
		}
		else if(status.equalsIgnoreCase("failure")) {
			updateMessage = "The Sales Record cannot be updated";
		}
		else {
			updateMessage = "Some Error Occured during update Operation";
		}
		
		//Fetching the Updated Details of the Product's Sales Report which has been updated
		SalorProductBean productSales = salorService.fetchProductService(recordno, userId, productId);
		session.setAttribute("productToUpdate", productSales);
		
		request.setAttribute("updateMessage", updateMessage);
		RequestDispatcher rd = request.getRequestDispatcher("updatedInfo");
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
