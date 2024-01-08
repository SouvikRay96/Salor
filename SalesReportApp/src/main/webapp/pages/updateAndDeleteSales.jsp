<%@page import="com.salor.bean.SalorProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Update Sales</title>
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
	<!-- Header Section -->
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div>
	
	<%
		SalorProductBean[] salesReport = (SalorProductBean[])session.getAttribute("productsales");
	%>
	
	<!-- Body Section -->
	<h2>${productId } -- ${productName } </h2>
		<br>
		<center><h3 style="color: white">${deleteSalesMessage } </h3></center>
		<br>
	
	<div class="table-wrapper">
	    <table class="fl-table">
	        <thead>
	        <tr>
	        	<th style="font-size: 14px">Record Number</th>
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
	            <th style="font-size: 14px">Update Record</th>
	            <th style="font-size: 14px">Delete Record</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="<%=salesReport %>" var="sales">
	        	<tr>
	        		<td style="font-size: 14px;color: black">${sales.getRecordno() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getCostPerProduct() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getSpPerProduct() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getQuantityManufactured() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getQuantitySold() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getTotalCostOfProduction() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getTotalSales() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getNetProfit() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getNetLoss() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getDateBought() }</td>
	        		<td style="font-size: 14px;color: black">${sales.getDateSold() }</td>
	        		<td><a href="updatedeletesalesreportservlet?operation=update&recordno=${sales.getRecordno() }"><button type="button" class="btn btn-success" style="background-color: green;color: white;font-size: 12px">Edit</button></a></td>
	        		<td><a href="updatedeletesalesreportservlet?operation=delete&recordno=${sales.getRecordno() }"><button type="button" class="btn btn-danger" style="background-color: red;color: white;font-size: 12px">Delete</button></a></td>
	        	</tr>
	        
	        </c:forEach>
	        <tbody>
	    </table>
	</div>	
	
	
	<br><br>
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
</body>
</html>