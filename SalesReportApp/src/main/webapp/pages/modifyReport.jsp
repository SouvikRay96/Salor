<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Modify Sales</title>
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
		<form action="viewsalesreportservlet?opcode=modify" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Modify Product's Sales</h2>
			<span style="color:red">${errorMessage }</span>
    		
    		<label for="fname" class="label">Name of the Product you want to Modify</label><br>
				<span id="pdtnameError" style="color:red"></span>				
				<select name="productName">
					<option>--Select the Product--</option>
					<c:forEach items="${productList }" var="pdt">
						<option value="${pdt }">${pdt }</option>
					</c:forEach>
				</select>
		
			<br>
		    <input type="submit" value="View Sales">
		
		</form>
	<!-- Footer Section -->
	<%@include file="footer.jsp" %> 
	<!-- Adding Script file -->
    
</body>
</html>