<%@page import="com.salor.bean.SalorProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Update Product</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
<link rel="stylesheet" href="pages/tablestyle.css">
</head>
<body>

	<%
			//Controlling the Back Button after Log_out
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
	%>

	<%String[] dates = new String[31];
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i = 1; i<=31; i++){
			dates[i-1] = Integer.toString(i);
		}
		SalorProductBean sales = (SalorProductBean)session.getAttribute("productToUpdate");
	%>
	
	<%@include file="header.jsp" %>
	<br><br><br>
	<h2>${productId } -- ${productName } </h2>
		<br>
		<%
			String displayMessage = null;
			if(request.getAttribute("updateMessage") != null){
				displayMessage = "<center><h3 style='color: white'>Updated Sale's Record </h3></center>";
			}
			else{
				displayMessage = "<center><h3 style='color: white'>Previous Sale's Record </h3></center>";
			}
		%>
		
		<%=displayMessage %>
		
		<br>
		<center><a href="FetchUpdatedRecords"><button class="btn">Back</button></a></center>
		<br>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
        	<th style="font-size: 14px">Record No.</th>
            <th style="font-size: 14px">Cost/Product</th>
            <th style="font-size: 14px">Selling Price/Product</th>
            <th style="font-size: 14px">Quantity Manufactured</th>
            <th style="font-size: 14px">Quantity Sold</th>
            <th style="font-size: 14px">Total Cost</th>
            <th style="font-size: 14px">Total Sales</th>
            <th style="font-size: 14px">Net Profit</th>
            <th style="font-size: 14px">Net Loss</th>
            <th style="font-size: 14px">Date Bought</th>
            <th style="font-size: 14px">Date Sold</th>
        </tr>
        </thead>
        <tbody>
        	<tr>
        		<td style="font-size: 14px;color: black"><%=sales.getRecordno() %> </td>
        		<td style="font-size: 14px;color: black"><%=sales.getCostPerProduct() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getSpPerProduct() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getQuantityManufactured() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getQuantitySold() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getTotalCostOfProduction() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getTotalSales() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getNetProfit() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getNetLoss() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getDateBought() %></td>
        		<td style="font-size: 14px;color: black"><%=sales.getDateSold() %></td>
        	</tr>
        <tbody>
    </table>
</div>	
		
		<form action="updatesalesreport" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Update Product's Sales</h2>
			<span style="color:red">${errorMessage }</span>
			
		    <label for="fname" class="label">Cost Price of the Product</label><br>
		    <span id="cpError" style="color:red"></span>
		    <input type="text" name="productcp" placeholder="Enter Product's CP">
		    
		    <label for="fname" class="label">Selling Price of the Product</label><br>
			<span id="spError" style="color:red"></span>
		    <input type="text" name="productsp" placeholder="Enter Product's SP">
		    
		    <label for="fname" class="label">Quantity Manufactured/Bought</label><br>
			<span id="quantityManError" style="color:red"></span>
		    <input type="text" name="quantityManufactured" placeholder="Number of Products Manufactured">
		    
		    <label for="fname" class="label">Quantity Sold</label><br>
			<span id="quantitySoldError" style="color:red"></span>
		    <input type="text" name="quantitySold" placeholder="Number of Products Sold">
		    
		    <label for="fname" class="label">Date Bought/Manufactured</label><br>
		    <label for="fname" class="label">Date : </label><br>
				<span id="dateboughtError" style="color:red"></span>				
				<select name="dateBought">
					<option>--Select Date--</option>
					<c:forEach items="<%=dates %>" var="date">
						<option value="${date }">${date }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">Month : </label><br>
				<span id="monthboughtError" style="color:red"></span>				
				<select name="monthBought">
					<option>--Select Month--</option>
					<c:forEach items="<%=months %>" var="month">
						<option value="${month }">${month }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">Year : </label><br>
				<span id="yearBoughtError" style="color:red"></span>
			    <input type="text" name="yearBought" placeholder="Enter Year">
			    
		    <br>
		    	<label for="fname" class="label">Date Sold</label><br>
			    <label for="fname" class="label">Date : </label><br>
					<span id="datesoldError" style="color:red"></span>				
					<select name="dateSold">
						<option>--Select Date--</option>
						<c:forEach items="<%=dates %>" var="date">
							<option value="${date }">${date }</option>
						</c:forEach>
					</select>
					
					<label for="fname" class="label">Month : </label><br>
					<span id="monthsoldError" style="color:red"></span>				
					<select name="monthSold">
						<option>--Select Month--</option>
						<c:forEach items="<%=months %>" var="month">
							<option value="${month }">${month }</option>
						</c:forEach>
					</select>
					
					<label for="fname" class="label">Year : </label><br>
					<span id="yearsoldError" style="color:red"></span>
			    	<input type="text" name="yearSold" placeholder="Enter Year">
			    
		    <br><br>
		    <input type="submit" value="Update Sales">
		</form>
		
		<!-- Form Validation logics -->
		<script type="text/javascript" src = "pages/signupformvalidations.js"></script>
		
	<br><br>
	    <%@include file="footer.jsp" %>
</body>
</html>