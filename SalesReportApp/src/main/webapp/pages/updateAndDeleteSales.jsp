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
		<center><h3 style="color: white">${filterMessage } </h3></center>
		<br>
	<div class="table-wrapper">
	    <table class="fl-table">
	        <thead>
	        <tr>
	            <th style="font-size: 15px">Cost/Product</th>
	            <th style="font-size: 15px">Selling Price/Product</th>
	            <th style="font-size: 15px">Quantity Manufactured</th>
	            <th style="font-size: 15px">Quantity Sold</th>
	            <th style="font-size: 15px">Total Cost</th>
	            <th style="font-size: 15px">Total Sales</th>
	            <th style="font-size: 15px">Net Profit</th>
	            <th style="font-size: 15px">Net Loss</th>
	            <th style="font-size: 15px">Date Bought</th>
	            <th style="font-size: 15px">Date Sold</th>
	            <th style="font-size: 15px">Update Record</th>
	            <th style="font-size: 15px">Delete Record</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="<%=salesReport %>" var="sales">
	        	<tr>
	        		<td style="font-size: 16px">${sales.getCostPerProduct() }</td>
	        		<td style="font-size: 16px">${sales.getSpPerProduct() }</td>
	        		<td style="font-size: 16px">${sales.getQuantityManufactured() }</td>
	        		<td style="font-size: 16px">${sales.getQuantitySold() }</td>
	        		<td style="font-size: 16px">${sales.getTotalCostOfProduction() }</td>
	        		<td style="font-size: 16px">${sales.getTotalSales() }</td>
	        		<td style="font-size: 16px">${sales.getNetProfit() }</td>
	        		<td style="font-size: 16px">${sales.getNetLoss() }</td>
	        		<td style="font-size: 16px">${sales.getDateBought() }</td>
	        		<td style="font-size: 16px">${sales.getDateSold() }</td>
	        		<td><button type="button" class="btn btn-success" style="background-color: green;color: white">Edit</button></td>
	        		<td><button type="button" class="btn btn-danger" style="background-color: red;color: white">Delete</button></td>
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