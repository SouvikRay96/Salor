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
	
	
	<!-- Header Section -->
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div>
	
	<!-- Body Section -->
		<h2>${productId } -- ${productName } </h2>
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
        <!-- <tr>
            <td>Content 2</td>
            <td>Content 2</td>
            <td>Content 2</td>
            <td>Content 2</td>
            <td>Content 2</td>
        </tr>
        <tr>
            <td>Content 3</td>
            <td>Content 3</td>
            <td>Content 3</td>
            <td>Content 3</td>
            <td>Content 3</td>
        </tr>
        <tr>
            <td>Content 4</td>
            <td>Content 4</td>
            <td>Content 4</td>
            <td>Content 4</td>
            <td>Content 4</td>
        </tr>
        <tr>
            <td>Content 5</td>
            <td>Content 5</td>
            <td>Content 5</td>
            <td>Content 5</td>
            <td>Content 5</td>
        </tr>
        <tr>
            <td>Content 6</td>
            <td>Content 6</td>
            <td>Content 6</td>
            <td>Content 6</td>
            <td>Content 6</td>
        </tr>
        <tr>
            <td>Content 7</td>
            <td>Content 7</td>
            <td>Content 7</td>
            <td>Content 7</td>
            <td>Content 7</td>
        </tr>
        <tr>
            <td>Content 8</td>
            <td>Content 8</td>
            <td>Content 8</td>
            <td>Content 8</td>
            <td>Content 8</td>
        </tr>
        <tr>
            <td>Content 9</td>
            <td>Content 9</td>
            <td>Content 9</td>
            <td>Content 9</td>
            <td>Content 9</td>
        </tr>
        <tr>
            <td>Content 10</td>
            <td>Content 10</td>
            <td>Content 10</td>
            <td>Content 10</td>
            <td>Content 10</td>
        </tr> -->
        <tbody>
    </table>
</div>	
		
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
	<!-- Adding Script file -->
    
</body>
</html>