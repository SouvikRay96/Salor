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
                <a href='loginpage'><i class='bi bi-person-fill'></i> <b>Log-In</b></a>
            </li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn"><b>Facilities</b> <i id="drop_icon" class="bi bi-caret-down-fill"></i></button>
                    <div class="dropdown-content">
                    <!-- Change -->
                      <a href='#'>Insert Report Content</a>
                        <a href='#'>Update Report's Record(s)</a>
                        <a href='#'>Delete Report's Record(s)</a>
                        <a href='#'>Visualize Sales Report</a>
                        <a href='#'>Add Shops of the Company</a>
                    </div>
                </div>
            </li>
            <li>
                <a href="profile"><i class="bi bi-file-earmark-fill"></i> <b>Profile</b></a>
            </li>
            <li>
                <a href="homepage" id="this_nav"><i class="bi bi-house-fill"></i> <b>Home</b></a>
            </li>
            
            
            
        </ul>
    </nav>


</body>
</html>