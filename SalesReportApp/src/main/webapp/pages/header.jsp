<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SALOR | Home</title>
        <!-- CSS only -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <!-- <link rel="icon" type="image/jpg" href="./img/salesLogo.png"> -->
        <link rel="stylesheet" href="pages/style.css">
</head>
<body>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div> 
	
	<!-- Scriplet Tags if the Login is successful or not -->
	<%
		//Controlling the Back Button after Log_out
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		
		String log = null;
		String insertProductCard = null;
		String insertProductNav = null;
		String insertProductSalesNav = null,insertProductSalesCard = null;
		String deleteSalesNav = null,deleteSalesCard = null;
		String viewSalesNav = null,viewSalesCard = null;
		String updateNav = null,updateCard = null;
		if(session.getAttribute("pwd") != null && session.getAttribute("userid") != null){
			log = "<a href='logout'><i class='bi bi-person-fill'></i> <b>Log-Out</b></a>";
			insertProductCard = "<a href='insertpdturl'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			insertProductNav = "<a href='insertpdturl'>Insert Product Name</a>";
			insertProductSalesNav = "<a href='generatepdtListurl?opcode=ins'>Insert Product's Sales</a>";
			insertProductSalesCard = "<a href='generatepdtListurl?opcode=ins'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			deleteSalesNav = "<a href='generatepdtListurl?opcode=del'>Delete Product's Sales</a>";
			deleteSalesCard = "<a href='generatepdtListurl?opcode=del'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			viewSalesNav = "<a href='generatepdtListurl?opcode=view'>Visualize Sales Report</a>";
			viewSalesCard = "<a href='generatepdtListurl?opcode=view'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			updateNav = "<a href='generatepdtListurl?opcode=update'>Update Product's Sales Report</a>";
			updateCard = "<a href='generatepdtListurl?opcode=update'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			
		}
		else{
			log = "<a href='loginpage'><i class='bi bi-person-fill'></i> <b>Log-In</b></a>";
			insertProductCard = "<a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			insertProductNav = "<a href='loginpage'>Insert Product Name</a>";
			insertProductSalesNav = "<a href='loginpage'>Insert Product's Sales</a>";
			insertProductSalesCard = "<a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			deleteSalesNav = "<a href='loginpage'>Delete Product's Sales</a>";
			deleteSalesCard = "<a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			viewSalesNav = "<a href='loginpage'>Visualize Sales Report</a>";
			viewSalesCard = "<a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			updateNav = "<a href='loginpage'>Update Product's Sales Report</a>";
			updateCard = "<a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>";
			
		}
	%>
	    <!-- Navigation Bar -->
    <nav >
        <ul id="logo">
            <li>
                <a href="homepage"><img src="./img/salesLogo.png" id="logo_navigation" height="40px"></a>
            </li>
        </ul>

        <ul id="navigations">
            <li>
            <!-- Change -->
                <!-- <a href='loginpage'><i class='bi bi-person-fill'></i> <b>Log-In</b></a> -->
                <%=log %>
            </li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn"><b>Facilities</b> <i id="drop_icon" class="bi bi-caret-down-fill"></i></button>
                    <div class="dropdown-content">
                    <!-- Change -->
                      	<%=insertProductNav %>
                        <%=insertProductSalesNav %>
                        <%=deleteSalesNav %>
                        <%=viewSalesNav %>
                        <%=updateNav %>
                    </div>
                </div>
            </li>
            <li>
                <a href="ProfileServlet"><i class="bi bi-file-earmark-fill"></i> <b>Profile</b></a>
            </li>
            <li>
                <a href="homepage" id="this_nav"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
            
            
        </ul>
    </nav>


</body>
</html>