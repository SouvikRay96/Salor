<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Insert Product</title>
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
		<center><span style=color:green; font-weight:bolder>
			${insertmessage }
		</span></center>
		<form action="insertRecordurl" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Insert Product Name</h2>
			<!-- <span style="color:red">${errorMessage }</span> -->
			
				<label for="fname" class="label">Name of the Product</label><br>
				<span id="pdtnameError" style="color:red"></span>				
				<input type="text" name="pdtname" placeholder="Enter Name of the Product">
			
	    	<input type="submit" value="Submit Details">
		</form>
	
	<br><br>
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
</body>
</html>