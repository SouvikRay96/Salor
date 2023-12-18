<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Delete Product's Sales</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>

	<%
		//Declaring days,month and year array
		String[] days = new String[32];
		String[] months = {"January","February","March","April","May","June","July","August","September"
				,"October","November","December"};
		String[] years = new String[35];
		int j = 0;
		for(int i = 1; i<=31; i++)
			days[i-1] = Integer.toString(i);
		for(int i = 2020; i<=2050; i++)
			years[i-2020] = Integer.toString(i);
		
	%>
	<!-- Header Section -->
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div>
	
	<!-- Body Section -->
		<!-- <center><span style=color:green; font-weight:bolder>
			${message }
		</span></center> -->
		<form action="#" class="loginform" method = "post" onchange = "date()">
			<h2 class="title" style="color:black;text-align: center;">Delete Product Sales</h2>
			<span style="color:red">${errorMessage }</span>
			
				<label for="fname" class="label">Name of the Product</label><br>
				<span id="pdtnameError" style="color:red"></span>				
				<select name="productName">
					<option>--Select the Product--</option>
					<c:forEach items="${productList }" var="pdt">
						<option value="${pdt }">${pdt }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">Provide dates for the deletion of the Product's Sales</label><br>
				<label for="fname" class="label">From : </label><br>
				<span id="fromDateError" style="color:red"></span>				
				<select name="fromDate">
					<option>--Select the from Date--</option>
					<c:forEach items=<%=days %> var="day">
						<option value="${day }">${day }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">To : </label><br>
				<span id="fromDateError" style="color:red"></span>				
				<select name="fromDate">
					<option>--Select upto which Date--</option>
					<c:forEach items=<%=days %> var="day">
						<option value="${day }">${day }</option>
					</c:forEach>
				</select>
				
				
				<label for="fname" class="label">Provide months for the deletion of the Product's Sales</label><br>
				<label for="fname" class="label">From : </label><br>
				<span id="fromMonthError" style="color:red"></span>				
				<select name="fromMonth">
					<option>--Select from which Month--</option>
					<c:forEach items=<%=months %> var="month">
						<option value="${month }">${month }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">To : </label><br>
				<span id="fromDateError" style="color:red"></span>				
				<select name="fromDate">
					<option>--Select upto which Month--</option>
					<c:forEach items=<%=months %> var="month">
						<option value="${month }">${month }</option>
					</c:forEach>
				</select>
				
				
				<label for="fname" class="label">Provide Years for the deletion of the Product's Sales</label><br>
				<label for="fname" class="label">From : </label><br>
				<span id="fromDateError" style="color:red"></span>				
				<select name="fromDate">
					<option>--Select from which Year--</option>
					<c:forEach items=<%=years %> var="year">
						<option value="${year }">${year }</option>
					</c:forEach>
				</select>
				
				<label for="fname" class="label">To : </label><br>
				<span id="fromDateError" style="color:red"></span>				
				<select name="fromDate">
					<option>--Select upto which Year--</option>
					<c:forEach items=<%=years %> var="year">
						<option value="${year }">${year }</option>
					</c:forEach>
				</select>
				
			
	    	<input type="submit" value="Submit Details">
		</form> 
	
	<br><br>
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
</body>
</html>