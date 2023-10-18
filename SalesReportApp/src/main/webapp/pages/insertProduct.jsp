<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Home</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>
	<!-- Header Section -->
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div>
	
	<!-- Body Section -->
	
		<form action="insertRecordurl" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Insert Product Name</h2>
			<span style="color:red">${errorMessage }</span>
			
				<label for="fname" class="label">Name of the Product</label><br>
				<span id="pdtnameError" style="color:red"></span>				
				<input type="text" name="pdtname" placeholder="Enter Name of the Product">
			
			
				<!-- <label for="fname" class="label">Cost Price per Product</label><br>
				<span id="productcpError" style="color:red"></span>				
				<input type="text" name="productcp" placeholder="Enter Product's Cost Price">
			
			
				<label for="fname" class="label">Selling Price per Product</label><br>
				<span id="productspError" style="color:red"></span>			
				<input type="text" name="productsp" placeholder="Enter Product's Selling Price">
			
			
				<label for="fname" class="label">Quantity Bought / in Stock / Manufactured</label><br>
				<span id="productStockError" style="color:red"></span>				
				<input type="text" name="productStock" placeholder="Enter Quantity Bought / in Stock">
			
			
				<label for="fname" class="label">Quantity Sold</label><br>
				<span id="productSoldError" style="color:red"></span>				
				<input type="text" name="productSold" placeholder="Enter Quantity Sold">
				
				<label for="fname" class="label">Date in which the Products were Bought</label><br>
				<span id="dateBoughtError" style="color:red"></span>				
				<input type="text" name="dateBought" placeholder="Enter Bought Date">
			
				<label for="fname" class="label">Date in which the Above Quantity was sold</label><br>
				<span id="dateSoldError" style="color:red"></span>				
				<input type="text" name="dateSold" placeholder="Enter Sold Date"> -->
			
	    	<input type="submit" value="Submit Details">
		</form>
	
	<br><br>
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
</body>
</html>