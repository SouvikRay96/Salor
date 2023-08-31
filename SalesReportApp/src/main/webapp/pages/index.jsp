<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salor | Home</title>
</head>
<body>
	
	<%@include file="header.jsp" %>
	<!-- Background Animation -->	
	<div class="bg"></div>
	<div class="bg bg2"></div>
	<div class="bg bg3"></div> 
	
	     <!-- Content of the page -->
    		<div class="inner">
                <h2 class="title">Salor</h2>
                <p>
                  An App to <b>CREATE</b> and <b>MAINTAIN</b> the <u>Annual</u>, <u>Monthly</u> or <u>Weekly</u>
                  Sales Report of an <b>Organization</b></p>
                  <div class="extramsg hidden">
                  <br>
                  <p>
                  	In this Application we can Create an Account for any Particular Organization and
                  	can Create and Maintain the Sales Report for that Organization in Annually , Monthly or Weekly Basis.
                  	We can use Graphical Representations like Charts to visualize the Sales Report of the Organization.
                  	We can Edit, Insert and Delete Records in the Sales Report of the Organization.
                  	</p>
                  </div>
                
                <button class="btn">Read more</button>
                </div>
          <!-- <div>
          <br><br><br>
          	<hr class="dashed">
          </div> -->
          
          <!-- Cards -->
    <div id="cards">
        <div class="container d-flex align-items-center justify-content-center flex-wrap">
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Insert Report Content</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">Inserting of the sales records to the Report</h3>
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Update Report's Record(s)</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">Updating Sales Records in the Sales Report of the Company </h3>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Delete Report's Record(s)</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">Deletion of Sales Records from the Sales Report of the Company </h3>
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Visualize the Sales Report</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">Visualizing the Sales Report and Profit and Loss Statements 
                            </h3>
                            
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="box">
                <div class="body">
                    <div class="imgContainer">
                        <hr>
                        <h1>Add Shops Under the Company</h1>
                        <hr>
                    </div>
                    <div class="content d-flex flex-column align-items-center justify-content-center">
                        <div>
                            <h3 class="text-white fs-5">Addition of shops under the company (if any) 
                            </h3>
                            
                            <br>
                            <br>
                            <div class="procedButton">
                            <!-- Change -->
                                <a href='loginpage'><b>Proceed </b><i class='bi bi-arrow-right-circle-fill'></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
    </div>
	
	
	<%@include file="footer.jsp" %>
</body>
</html>