<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Login</title>
<link rel="stylesheet" href="pages/LoginformStyles.css">
</head>
<body>
	
	<%@include file="header.jsp" %>
	<br><br><br>
	
		<%
			if(session.getAttribute("userId") != null){
				out.println("<center><span style='color:green; font-weight:bolder'>"+"You are Successfully Registered with Salor.<br>"
		+"Kindly Login with the UserId : "+session.getAttribute("userId")+" To avail all the facilities of Salor.</span></center><br>");
			}
		%>
		
		<form action="loginurl" class="loginform" method = "post" onsubmit = "return validate(this)">
			<h2 class="title" style="color:black;text-align: center;">User Login</h2>
    		<label for="fname" class="label">Name of the Organization</label><br>
		    <span id="orgNameError" style="color:red"></span>
		    <input type="text" name="orgname" placeholder="Enter Name of the Organization">
			
		    <label for="fname" class="label">Email ID</label><br>
		    <span id="emailidError" style="color:red"></span>
		    <input type="text" name="emailid" placeholder="Enter Email ID">
		    
			<label for="fname" class="label">User ID</label><br>
			<span id="useridError" style="color:red"></span>
		    <input type="text" name="userid" placeholder="Enter User ID">
		    
		    <label for="fname" class="label">User Password</label><br>
			<span id="pwdError" style="color:red"></span>
		    <input type="password" name="pwd" placeholder="Enter Your Password">
		    
		    

			
			<center>Not a User !!! &nbsp &nbsp
			<a href="register" style="--i: 0.05s;" class="userlinks" >
				Sign-Up
			</a></center>
		    
		    <br><br>
		    <input type="submit" value="Log-In">
		</form>
		
		<!-- Form validations Logics -->
		<script type="text/javascript" src="loginformvalidations.js"></script>
		
	<br><br>
	    <%@include file="footer.jsp" %>
</body>
</html>