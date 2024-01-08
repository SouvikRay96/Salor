<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
			//Controlling the Back Button after Log_out
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
	%>
	
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