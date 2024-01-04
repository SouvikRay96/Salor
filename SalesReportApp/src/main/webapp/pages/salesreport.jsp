<%@page import="com.salor.bean.SalorProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | View Sales</title>
<link rel="stylesheet" href="pages/LoginformStyles.css"> 
<link rel="stylesheet" href="pages/tablestyle.css">
</head>
<body>

	<%
		SalorProductBean[] salesReport = (SalorProductBean[])session.getAttribute("productsales");
	%>
	
	<%
		String[] dates = new String[31];
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i = 1; i<=31; i++){
			dates[i-1] = Integer.toString(i);
		}
	%>
	
	
	<!-- Header Section -->
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div>
	
	<!-- Body Section -->
		<h2>${productId } -- ${productName } </h2>
		<br>
		<center><h3 style="color: white">${filterMessage } </h3></center>
		<br>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Cost/Product</th>
            <th>Selling Price/Product</th>
            <th>Quantity Manufactured</th>
            <th>Quantity Sold</th>
            <th>Total Cost</th>
            <th>Total Sales</th>
            <th>Net Profit</th>
            <th>Net Loss</th>
            <th>Date Bought</th>
            <th>Date Sold</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="<%=salesReport %>" var="sales">
        	<tr>
        		<td>${sales.getCostPerProduct() }</td>
        		<td>${sales.getSpPerProduct() }</td>
        		<td>${sales.getQuantityManufactured() }</td>
        		<td>${sales.getQuantitySold() }</td>
        		<td>${sales.getTotalCostOfProduction() }</td>
        		<td>${sales.getTotalSales() }</td>
        		<td>${sales.getNetProfit() }</td>
        		<td>${sales.getNetLoss() }</td>
        		<td>${sales.getDateBought() }</td>
        		<td>${sales.getDateSold() }</td>
        	</tr>
        
        </c:forEach>
        <tbody>
    </table>
</div>	

<form action="filtersalesreport" class="loginform" method="post">
		<h3>Date Bought/ Manufactured</h3>

		<select name="dateBought">
			<option>--Select Date--</option>
			<c:forEach items="<%=dates %>" var="date">
				<option value="${date }">${date }</option>
			</c:forEach>
		</select>
				
		<select name="monthBought">
		    <option>--Select Month--</option>
			<c:forEach items="<%=months %>" var="month">
				<option value="${month }">${month }</option>
			</c:forEach>
		</select> 
		
		<select name="yearBought">
		    <option value="hide">-- Year --</option>
		    <option value="2020">2020</option>
		    <option value="2021">2021</option>
		    <option value="2022">2022</option>
		    <option value="2023">2023</option>
		    <option value="2024">2024</option>
		    <option value="2025">2025</option>
		    <option value="2026">2026</option>
		    <option value="2027">2027</option>
		    <option value="2028">2028</option>
		    <option value="2029">2029</option>
		    <option value="2030">2030</option>
		</select>	
		<br>
		<h3>Date Sold</h3>

		<select name="dateSold">
			<option>--Select Date--</option>
			<c:forEach items="<%=dates %>" var="date">
				<option value="${date }">${date }</option>
			</c:forEach>
		</select>
				
		<select name="monthSold">
		    <option>--Select Month--</option>
			<c:forEach items="<%=months %>" var="month">
				<option value="${month }">${month }</option>
			</c:forEach>
		</select> 
		
		<select name="yearSold">
		    <option value="hide">-- Year --</option>
		    <option value="2020">2020</option>
		    <option value="2021">2021</option>
		    <option value="2022">2022</option>
		    <option value="2023">2023</option>
		    <option value="2024">2024</option>
		    <option value="2025">2025</option>
		    <option value="2026">2026</option>
		    <option value="2027">2027</option>
		    <option value="2028">2028</option>
		    <option value="2029">2029</option>
		    <option value="2030">2030</option>
		</select>	
		<br><br>
		<input type="submit" class="submitbtn" value="Click to View">
	</form>
	<br>
	<br>
	
		
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
	<!-- Adding Script file -->
    
</body>
</html>