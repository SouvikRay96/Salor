<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Login-Signup</title>
</head>
<body>
	
	<%@include file="header.jsp" %>
	<br><br><br>
	<!-- container div -->
    <div class="logincontainer">
 
        <!-- upper button section to select
             the login or signup form -->
        <div class="slider"></div>
        <div class="btn">
            <button class="login">Login</button>
            <button class="signup">Signup</button>
        </div>
 
        <!-- Form section that contains the
             login and the signup form -->
        <div class="form-section">
 
            <!-- login form -->
            <div class="login-box">
                <input type="email"
                       class="email ele"
                       placeholder="youremail@email.com">
                <input type="password"
                       class="password ele"
                       placeholder="password">
                <button class="clkbtn">Login</button>
            </div>
 
            <!-- signup form -->
            <div class="signup-box">
                <input type="text"
                       class="name ele"
                       placeholder="Enter your name">
                <input type="email"
                       class="email ele"
                       placeholder="youremail@email.com">
                <input type="password"
                       class="password ele"
                       placeholder="password">
                <input type="password"
                       class="password ele"
                       placeholder="Confirm password">
                <button class="clkbtn">Signup</button>
            </div>
        </div>
    </div>
    <br><br>
    <!-- Adding Script file -->
    <script type="text/javascript" src="pages/loginscript.js"></script>
    <%@include file="footer.jsp" %>
</body>
</html>