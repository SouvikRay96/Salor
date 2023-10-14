<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Profile</title>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div> 
	
	<div class="inner">
		<h2 class="title">Salor Profile</h2>
     </div>
     <br>
     <br>
	<div class="profileBox">
		<b>User - Id : </b><c:out value="${userid }"></c:out>
		<br>
		<b>Organization Name : </b><c:out value="${orgname }"></c:out>
		<br>
		<b>Email - Id :  </b><c:out value="${emailid }"></c:out>
		<br>
		<b>Address : </b><c:out value="${address }"></c:out>
		<br>
		<b>Organization Size : </b><c:out value="${orgsize }"></c:out>
		<br>
		<b>Owner Name : </b><c:out value="${ownername }"></c:out>
	</div>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>