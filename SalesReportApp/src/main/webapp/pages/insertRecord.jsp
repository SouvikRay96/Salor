<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Insert</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>

	<%String[] dates = new String[31];
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i = 1; i<=31; i++){
			dates[i-1] = Integer.toString(i);
		}
	%>
	
	<%@include file="header.jsp" %>
	<br><br><br>
		<center><span style=color:green; font-weight:bolder>
			${productSalesMessage }
		</span></center>
		
		<form action="insertpdtsales" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Insertion of Product's Sales</h2>
			<span style="color:red">${errorMessage }</span>
    		
    		<label for="fname" class="label">Name of the Product</label><br>
				<span id="pdtnameError" style="color:red"></span>				
				<select name="productName">
					<option>--Select the Product--</option>
					<c:forEach items="${productList }" var="pdt">
						<option value="${pdt }">${pdt }</option>
					</c:forEach>
				</select>
			
		    <label for="fname" class="label">Cost Price of the Product</label><br>
		    <span id="cpError" style="color:red"></span>
		    <input type="text" name="productcp" placeholder="Enter Product's CP">
		    
		    <label for="fname" class="label">Selling Price of the Product</label><br>
			<span id="spError" style="color:red"></span>
		    <input type="text" name="productsp" placeholder="Enter Product's SP">
		    
		    <label for="fname" class="label">Quantity Manufactured</label><br>
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
				<span id="yearboughtError" style="color:red"></span>
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
		    <input type="submit" value="Insert">
		</form>
		
		<!-- Form Validation logics -->
		<script type="text/javascript" src = "pages/signupformvalidations.js"></script>
		
	<br><br>
	    <%@include file="footer.jsp" %>
</body>
</html>