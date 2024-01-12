# Salor
A Java Based Sales Report Maker and Visualizer Application

Technologies Used
---------------------
1) Frontend Tools : 
---------------------
    a) HTML
    b) CSS
    c) JavaScript
    d) JSP
    e) JSTL

2) Backend Tools :
--------------------
    a) Java
    b) Servlets
    c) JDBC

--------------------------------
Purpose of the Application
--------------------------------
Salor Application is a Sales Report Maker and Visualizing the Sales Report of that Organization. The Organization can ADD and DELETE products to their database and can add Sales of each corresponding products.The Organization can editand delete the Sales Report of the products, filter the Sales Report according to the Dates (Anually and Monthly Basis).

---------------------------------
Functionalities of the Application
---------------------------------
1) Insertion of New Products
---------------------------------
    This Feature of the Application enables an Organization to Insert any new Product of the Organization to it's Database. 
    After the Insertion of the New Product to the Organization's Database a ProductID will be automatically generated along with the creation of a Table which will store the Sales Report of that Particular Product. 
    Each Product will have an unique ProductID along with a Sales Table which will contain the Sales Report of that particular Product. 
    The Product's Sales Table will be named according to the unique ProductID generated for the Product. 
    The table will consists of the following columns : 
        1) Cost Price Per Product
        2) Selling Price Per Product
        3) Total Cost Price
        4) Total Sales
        5) Quantity Bought / Manufactured
        6) Quantity Sold
        7) Net Profit on the Particular Stock
        8) Net Loss on that Particular Stock
        9) Date on which that Particular Stock of product was bought/Manufactured
        10) Date on which that particular Stock of product was sold.(It may be after one month,two months etc..)
        11) Lastly a Record Number which will be associated to each and every Sales Record.

2) Insertion of the Product's Sales
---------------------------------------
    This Feature enables one Organizatiion to Insert the Sales Records of any particular Product. 
    The User have to provide which product's Sales record he/she wants to insert from the list of product's available in their Organization. 
    Then they have to provide the Record number, Cost Price Per Product, Selling Price per Product, Quantity Bought/Manufactured, Quantity Sold of that Particular Lot, Date on which that Particular Stock was bought/manufactured & Date on which that entered quantity was sold for that particular Stock. 
    After giving these Details The Total Cost of Production, Total Sales, Net Profit / Net Loss will be calculated and the Sales record provided by the User will be Added to the table created for that particular Product. 
    After Adding the Record Successfully appropriate message will be given in the Screen. 
    NOTE : The Record Number must be unique for each and every record. 
    If two records having the same record number is inserted then there will be an error as Record Number is acting like a primary key for each Sales record.


3) Delete Product along with the Sales Report Associated with the Product
----------------------------------------------------------------------------
    This feature enables an Organization to delete all the details of the Sales of the product along with the Product from the Organization's database.
    First we have to Select the product which we want to delete from the list of available products in the Organization.
    After Selection of the product, the product from the Product List of the Organization will be deleted along with the table that is associated for the sales of the product.

4) Vizualizing The Sales Report of a particular product
----------------------------------------------------------
    This feature enables an Organization to View the Sales report of a particular Product selected from the productList of the Organization.
    After the selection of the product from the product list the required product's Sales is displayed.
    The Organization can also filter the data from the Product's Sales Report based on the dates in the Sales Report.
    