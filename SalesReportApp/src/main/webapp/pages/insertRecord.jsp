<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Insert</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>
	
	<%@include file="header.jsp" %>
	<br><br><br>
	
		<form action="insertRecordurl" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">Insertion of Products</h2>
			<span style="color:red">${errorMessage }</span>
    		
    		<label for="fname" class="label">Name of the Product</label><br>
		    <span id="pdtNameError" style="color:red"></span>
		    <input type="text" name="pdtName" placeholder="Enter Product Name">
			
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
		    
		    
		    <br><br>
		    <input type="submit" value="Insert">
		</form>
		
		<!-- Form Validation logics -->
		<script type="text/javascript" src = "pages/signupformvalidations.js"></script>
		
	<br><br>
	    <%@include file="footer.jsp" %>
</body>
</html>