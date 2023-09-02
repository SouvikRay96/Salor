<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Signup</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>
	
	<%@include file="header.jsp" %>
	<br><br><br>
	
	
		<form action="#" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">User Registration</h2>
    		
    		<label for="fname" class="label">Name of the Organization</label><br>
		    <span id="orgnameError" style="color:red"></span>
		    <input type="text" name="orgname" placeholder="Enter Name of the Organization">
			
		    <label for="fname" class="label">Email ID</label><br>
		    <span id="emailError" style="color:red"></span>
		    <input type="text" name="email" placeholder="Enter Email ID">
		    
		    <label for="fname" class="label">Full Address</label><br>
			<span id="addressError" style="color:red"></span>
		    <input type="text" name="address" placeholder="Enter full address">
		    
			<label for="fname" class="label">Number of Shops</label><br>
			<span id="noshopsError" style="color:red"></span>
		    <input type="text" name="noshops" placeholder="Enter number of shops">
		    
		    <label for="fname" class="label">Organization Size</label><br>
			<span id="orgsizeError" style="color:red"></span>
		    <input type="text" name="orgsize" placeholder="Small/Medium/Large">
		    
		    <label for="fname" class="label">Name of the Owner</label><br>
			<span id="ownernameError" style="color:red"></span>
		    <input type="text" name="ownername" placeholder="Owner's Name">
		    
		    <label for="fname" class="label">User Password</label><br>
			<span id="passwordError" style="color:red"></span>
		    <input type="password" name="password" placeholder="Enter Your Password">
		    
		    <label for="fname" class="label">Confirm Password</label><br>
			<span id="cnfpasswordError" style="color:red"></span>
		    <input type="password" name="cnfpassword" placeholder="Enter Your Password Again">
		    
		    

			
			<center>Already a User !!! &nbsp &nbsp
			<a href="loginpage" style="--i: 0.05s;" class="userlinks" >
				Log-In
			</a></center>
		    
		    <br><br>
		    <input type="submit" value="Register">
		</form>
		
		<!-- Form Validation logics -->
		<script type="text/javascript" src = "pages/signupformvalidations.js"></script>
		
	<br><br>
	    <%@include file="footer.jsp" %>
</body>
</html>