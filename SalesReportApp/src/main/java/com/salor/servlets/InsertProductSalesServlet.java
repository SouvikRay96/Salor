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
 * Servlet implementation class InsertProductSalesServlet
 */
@WebServlet("/insertpdtsales")
public class InsertProductSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the contentType of the page
		response.setContentType("text/html");
		
		//Getting the userId from the Session Object
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userid");
		
		//Retrieving the values from the form 
		String product = request.getParameter("productName");
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
		
		String[] temp = product.split("--");
		String productId = temp[0],productName = temp[1];
		
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
		salorpdt.setProductId(productId);
		salorpdt.setProductName(productName);
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
		
		//Calling the Service class insertProductSalesService method to communicate with the database
		String status = salorService.insertProductSalesService(salorpdt, userId);
		String productSalesMessage = null;
		
		//Now Checking the status of the Insertion
		if(status.equalsIgnoreCase("success")) {
			productSalesMessage = "Insertion of the Product Sales is Successfully Completed";
		}
		else if(status.equalsIgnoreCase("failure")) {
			productSalesMessage = "Some Error Occured while inserting the Product Sales Details.";
		}
		else if(status.equalsIgnoreCase("error")) {
			productSalesMessage = "There is some issue with the coding section\n Details can't be inserted.";
		}
		else {
			productSalesMessage = status;
		}
		
		//Setting the productSalesMessage attribute
		session.setAttribute("productSalesMessage", productSalesMessage);
		System.out.println(productSalesMessage);
		response.sendRedirect("insertProductSales");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
