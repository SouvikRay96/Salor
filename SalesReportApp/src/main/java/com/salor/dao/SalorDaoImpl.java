package com.salor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;
import com.salor.factory.ConnectionFactory;
import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

public class SalorDaoImpl implements SalorDaoInterface {

	@Override
	public String[] productList(String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		String[] productList = new String[1000];
		int i = 0;
		
		try {
			
			//Establishing Connection with the Organization database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating Query to get all the records in the Product Table
			String query = "SELECT * FROM PRODUCTLIST";
			
			//Execution of the Query to fetch the records from the ProductList Table
			if(st != null) {
				rst = st.executeQuery(query);
			}
			
			//Fetching the Records from the ResultSet Object
			while(rst.next()) {
				productList[i] = rst.getString(1)+"--"+rst.getString(2);
				i++;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return productList;
	}

	private static Connection connectOrgDatabase(String userId) {
		Connection con = null;
		
		try {
			String database = "jdbc:mysql://localhost:3306/"+userId;
			con = DriverManager.getConnection(database, "root", "tojosoumili12");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	private static String orgDatabaseCreation(String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		try {
			//Establishing Connection with the salor database
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Command to create the database for the Organization
			String query = "CREATE DATABASE "+userId;
			
			boolean flag = false;
			//Executing the command for creation of the database
			if(st != null) {
				flag = st.execute(query);
				SalorDaoImpl.productListTableCreation(userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return null;
	}
	
	private static String productListTableCreation(String userId) {
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		try {
			//Establishing Connection with the Organization Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Command for creating the ProductList Table for the registered Organization 
			String create = "CREATE TABLE PRODUCTLIST(PRODUCT_ID VARCHAR(15) PRIMARY KEY,PRODUCT_NAME VARCHAR(26))";
			
			//Declaring a variable flag for keeping tab of the table Creation
			boolean flag = false;
			//Executing the query
			if(st != null) {
				flag = st.execute(create);
			}
			if(flag)
				return "success";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		
		return "failure";
	}
	@Override
	public String checkProductId(String productId,String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Declaring a status variable for checking that the product Id generated is valid
		String status = null;
		//Declaring a flag variable to keep a tab that the database of the Organization is found
		int flag = 0;
		
		boolean c = true;
		
		try {
			
			//Establishing Connection with the Organization Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Checking the ProductId is valid or not
			if(st != null) {
				String query = "SELECT PRODUCT_ID FROM PRODUCTLIST";
				rst = st.executeQuery(query);
				while(rst.next()) {
					if(productId.equalsIgnoreCase(rst.getString(1))) {
						flag = 1;
						break;
					}
				}
				
			}
			if(flag == 0) {
				status = "success";
			}
			else {
				status = "failure";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public String registerAccount(SalorAccountsRegister accReg) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		//Declaring a variable status for insertion of the account satus to the Database
		String status = null;
		//Declaring a count variable to keep a tab how many rows are affected in the Database
		int count  = 0;
		
		//Creating the variable of SalorAccountsRegister Class suitable for execution
		String userId = "'"+accReg.getUserId()+"'";
		String orgName = "'"+accReg.getOrgName()+"'";
		String emailid = "'"+accReg.getEmailId()+"'";
		String address = "'"+accReg.getAddress()+"'";
		String orgSize = "'"+accReg.getOrgSize()+"'";
		String ownerName = "'"+accReg.getOwnerName()+"'";
		String pwd = "'"+accReg.getPassword()+"'";
		
		try {
			
			//Establishing Connection With the Database
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object for the Execution of the Statement
			if(con != null) {
				st = con.createStatement();
			}
			//Creating the Query
			String queryString = "INSERT INTO ACCOUNTS VALUES("+userId+","+orgName+","+emailid+","+address+","+orgSize+","+ownerName+","+pwd+")";
			
			//Execution of the Query to insert Accounts Records into the database
			if(st != null) {
				count = st.executeUpdate(queryString);
			}
			
			//Generating Status
			if(count == 1) {
				status = "success";
				//After Successful Registration create a database for the Organization
				//and create a table named ProductList in that Organization Database
				String status1 = SalorDaoImpl.orgDatabaseCreation(accReg.getUserId());
				System.out.println("Organization databse and ProductList Table Creation of that database is successful");
					
				
			}
			else
				status = "failure";
			
		} catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to Primary Key Column.");
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be Inserted to primary key column.");
			if(se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Inavlid column Names or table name or SQL keywords");
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data columns");
			System.out.println(se.toString());
			status = "error";
		}
		catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}
		finally {
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public String[] profileInfo(String userid) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Creating Profile Info String Array
		String[] profileInfo = new String[7];
		try {
			
			//Establishing Connection with the Database
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating the Resultset and Execution of the SQL Commands
			if(st != null) {
				rst = st.executeQuery("SELECT * FROM ACCOUNTS WHERE USER_ID = '"+userid+"'");
				
				//Fetching the Profile Information from the ResultSet Object
				if(rst.next()) {
					for(int i = 1; i<=7; i++) {
						profileInfo[i-1] = rst.getString(i);
					}
				}
			}
			
		} catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to Primary Key Column.");
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be Inserted to primary key column.");
			if(se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Inavlid column Names or table name or SQL keywords");
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data columns");
			System.out.println(se.toString());
			se.printStackTrace();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return profileInfo;
	}

	@Override
	public String checkUserId(String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		int flag = 0;
		
		try {
			//Establishing Connection with the Database and Creating Connection Object
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating resultSet and Execution of the SQL command
			if(st != null) {
				rst = st.executeQuery("SELECT USER_ID FROM ACCOUNTS");
				if(rst == null) {
					return "success";
				}
				while(rst.next()) {
					if(userId.equals(rst.getString(1))) {
						flag = 1;
						break;
					}
				}
				if(flag == 1) {
					return "duplicate";
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return "success";
	}

	@Override
	public String loginAccount(SalorAccountLogin accLog) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst1 = null;
		
		try {
			//Establishing the Database Connection
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating the SQL Query
			//select email_id,password from accounts where user_id="ORG869"
			String queryString = "SELECT EMAIL_ID,PASSWORD,ORGANIZATION_NAME FROM ACCOUNTS WHERE USER_ID = '"+accLog.getUserId()+"'";
			
			//Creating ResultSet Object
			if(st != null) {
				//Executing the Query
				rst1 = st.executeQuery(queryString);
				
				if(rst1.next()) {
					if(rst1.getString(1).equals(accLog.getEmailId()) && rst1.getString(2).equals(accLog.getPassword())) {
						return "success";
					}
					if(!(rst1.getString(3).equals(accLog.getOrgName())))
						return "orgNameMismatch";
					if(!(rst1.getString(1).equals(accLog.getEmailId())))
						return "emailMismatch";
					if(!(rst1.getString(2).equals(accLog.getPassword())))
						return "passwordMismatch";
				}
				else {
					return "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rst1 != null) {
					rst1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String insertProduct(SalorProductBean pdt,String userId) {

		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		//Declaring the status variable for successful insertion or not
		String status = null;
		
		//Declaring a flag variable to check whether the product table exist or not
		int flag = 0;
		
		//Retrieving the values of the SalorProductBean Object
		String productId = pdt.getProductId();
		String productName = pdt.getProductName();
		
		
		try {
			
			//Establishing the Connection with the database of the Organization
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating the Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			
			
			//If the product is not present in the ProductList then
			//Insert the product into the ProductList
			//And create a table of the product with the required fields which is named as of ProductId. 
			if(flag == 0) {
				//Command for creation of the Product Table according to the generated Id
				String createTable = " CREATE TABLE "+productId
						+"(RECORD_NO INT PRIMARY KEY,COST_PRICE_PER_PRODUCT DOUBLE(7,3),"
						+"SELLING_PRICE_PER_PRODUCT DOUBLE(7,3),"
						+"QUANTITY_IN_STOCK INT,"
						+"QUANTITY_SOLD INT,"
						+"TOTAL_COST_OF_PRODUCTION DOUBLE(9,3),"
						+"TOTAL_SALES DOUBLE(9,3),"
						+"NET_PROFIT DOUBLE(6,3),"
						+"NET_LOSS DOUBLE(6,3),"
						+"DATE_BOUGHT DATE,DATE_SOLD DATE)";
				//Command for inserting the ProductId and the ProductName into the ProductList Table
				String insertProduct = "INSERT INTO PRODUCTLIST VALUES('"+productId+"','"+productName+"')";
				
				if(st != null) {
					boolean create = st.execute(createTable);
					int insert = st.executeUpdate(insertProduct);
					if(insert == 1) {
						status = "success";
					}
					else {
						status = "failure";
					}
				}
			}
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public String updateProduct(SalorProductBean pdt,String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		
		//Declaring a status variable to return the status after update
		String status = null;
		
		//Declaring a Counter variable to get how many rows are affected after updation of records
		int count = 0;
		
		//Initializing details of the product Sales to be updated
		String productId = pdt.getProductId();
		String recordno = Integer.toString(pdt.getRecordno());
		String productcp = Double.toString(pdt.getCostPerProduct());
		String productsp = Double.toString(pdt.getSpPerProduct());
		String quantityManufactured = Integer.toString(pdt.getQuantityManufactured());
		String quantitySold = Integer.toString(pdt.getQuantitySold());
		String totalCost = Double.toString(pdt.getTotalCostOfProduction());
		String totalSales = Double.toString(pdt.getTotalSales());
		String netProfit = Double.toString(pdt.getNetProfit());
		String netLoss = Double.toString(pdt.getNetLoss());
		String dateBought = "'"+pdt.getDateBought()+"'";
		String dateSold = "'"+pdt.getDateSold()+"'";
		
		try {
			
			//Establishing connection with the Organization's Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating the Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating the String query
			String query = "UPDATE "+productId
					+" SET COST_PRICE_PER_PRODUCT="+productcp
					+",SELLING_PRICE_PER_PRODUCT="+productsp
					+",QUANTITY_IN_STOCK="+quantityManufactured
					+",QUANTITY_SOLD="+quantitySold
					+",TOTAL_COST_OF_PRODUCTION="+totalCost
					+",TOTAL_SALES="+totalSales
					+",NET_PROFIT="+netProfit
					+",NET_LOSS="+netLoss
					+",DATE_BOUGHT="+dateBought
					+",DATE_SOLD="+dateSold
					+" WHERE RECORD_NO="+recordno;
			
			//Executing the String query
			if(st != null) {
				count = st.executeUpdate(query);
				if(count == 1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return status;
	}

	@Override
	public String deleteProduct(SalorProductBean pdt,String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		//Declaring a status variable to return the status of deletion
		String status = null;
		
		//Getting the Record number and the ProductId to be deleted from the SalorProductBean Object
		int recordno = pdt.getRecordno();
		String productId = pdt.getProductId();
		
		//Declaring a counter variable which will give how many rows in the table are affected after the deletion of the product's sales record
		int count = 0; //Initially it will be Zero
		
		try {
			
			//Establishing Connection with the Organization Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating the Query for deletion of the Record
			String query = "DELETE FROM "+productId+" WHERE RECORD_NO="+recordno;
			
			//Execution of the query
			if(st != null) {
				count = st.executeUpdate(query);
				if(count == 1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public SalorProductBean[] visualizeReport(String pdtId,String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Creating a Salor Product Array to store all the sales record of the product
		SalorProductBean[] productsales = new SalorProductBean[100];
		SalorProductBean product = null;
		SalorProductBean[] salesReport = null;
		
		int i = 0; // Counter Variable
		
		try {
			
			//Establishing Connection with the Organization's Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating the Statement Object
			if(con != null)
				st = con.createStatement();
			
			//Creating the Query String to fetch all the records of the product
			String query = "SELECT * FROM "+pdtId;
			
			//Executing the query and creating resultset Object
			if(st != null) {
				rst = st.executeQuery(query);
			}
			
			while(rst.next()) {
				product = new SalorProductBean();
				product.setRecordno(Integer.parseInt(rst.getString(1)));
				product.setCostPerProduct(Double.parseDouble(rst.getString(2)));
				product.setSpPerProduct(Double.parseDouble(rst.getString(3)));
				product.setQuantityManufactured(Integer.parseInt(rst.getString(4)));
				product.setQuantitySold(Integer.parseInt(rst.getString(5)));
				product.setTotalCostOfProduction(Double.parseDouble(rst.getString(6)));
				product.setTotalSales(Double.parseDouble(rst.getString(7)));
				product.setNetProfit(Double.parseDouble(rst.getString(8)));
				product.setNetLoss(Double.parseDouble(rst.getString(9)));
				product.setDateBought(rst.getString(10));
				product.setDateSold(rst.getString(11));
				productsales[i] = product;
				i++;
			}
			salesReport = new SalorProductBean[i];
			for(int j = 0; j<i; j++) {
				salesReport[j] = productsales[j];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salesReport;

	}

	@Override
	public String deleteAllProductDetails(String pdtId, String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		//ResultSet rst = null;
		
		//Declaring a status variable for the successfull deletion of the product or not
		String status = null;
		
		//Initializing a count variable with zero to know how many rows are affected after deletion
		int count1 = 0,count2 = 0;
		
		try {
			
			//Establishing Connection with the Organization's Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Getting the Query Ready for the deletion of the product from the ProductList Table
			//And also dropping the product's Table
			String deletepdtQuery = "DELETE FROM PRODUCTLIST WHERE PRODUCT_ID='"+pdtId+"'";
			String deleteTableQuery = "DROP TABLE "+pdtId;
			
			if(st != null) {
				count1 = st.executeUpdate(deletepdtQuery);
				count2 = st.executeUpdate(deleteTableQuery);
				if(count1 == 1 && count2 == 0) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
			
			
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public String insertProductSales(SalorProductBean pdt, String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		//Declaring a count variable to keep a tab that how many rows got affected due to the insertion into the database
		int count = 0;
		
		//Declaring a status variable to see what's the status of the insertion of record into the database
		String status = null;
		
		try {
			
			//Establishing Connection with the Organizations database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Getting the values of the attributes of the SalorProductBean Class
			int recordno = pdt.getRecordno();
			String productId = pdt.getProductId();
			double productcp = pdt.getCostPerProduct();
			double productsp = pdt.getSpPerProduct();
			int quantityManufactured = pdt.getQuantityManufactured();
			int quantitySold = pdt.getQuantitySold();
			double totalCost = pdt.getTotalCostOfProduction();
			double totalSales = pdt.getTotalSales();
			double netProfit = pdt.getNetProfit();
			double netLoss = pdt.getNetLoss();
			String dateBought = "'"+pdt.getDateBought()+"'";
			String dateSold = "'"+pdt.getDateSold()+"'";
			
			//Creating the QueryString
			String query = "INSERT INTO "+productId+" VALUES("+recordno+","+productcp+","+productsp+","+quantityManufactured
					+","+quantitySold+","+totalCost+","+totalSales+","+netProfit+","+netLoss
					+","+dateBought+","+dateSold+")";
			
			if(st != null) {
				count = st.executeUpdate(query);
				if(count == 1) {
					status = "success";
				}
				else
					status = "failure";
			}
			
		}catch (SQLException se) {
			if(se.getErrorCode() == 1)
				status = "Duplicate cannot be inserted to Primary Key Column.";
			if(se.getErrorCode() == 1400)
				status = "Null cannot be Inserted to primary key column.";
			if(se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				status = "Inavlid column Names or table name or SQL keywords";
			if(se.getErrorCode() == 12899)
				status = "Do not insert more than column size data columns";
			System.out.println(se.toString());
			status = se.toString();
			se.printStackTrace();
			
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		} finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public String duplicateProduct(String productName, String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Declaring a status variable to return the status whether the product is duplicate or not
		String status = null;
		
		try {
			
			//Establishing the connection with the Organization Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating the Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating a Query for fetching all the products present in the Organization
			String query = "SELECT * FROM PRODUCTLIST";
			
			if(st != null) {
				rst = st.executeQuery(query);
				status = "success";
				while(rst.next()) {
					if(productName.equalsIgnoreCase(rst.getString(2))) {
						status = "duplicate";
						break;
					}
					else {
						status = "success";
					}
				}
			}
			
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}finally {
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public SalorProductBean[] filterSalesReport(String userId, String productId, String boughtDate, String soldDate) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Creating a Salor Product Array to store all the sales record of the product
		SalorProductBean[] productsales = new SalorProductBean[100];
		SalorProductBean product = null;
		SalorProductBean[] salesReport = null;
		
		int i = 0; // Counter Variable
		
		try {
			
			//Establishing Connection with the Organization's Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating Statement Object
			if(con != null)
				st = con.createStatement();
			
			//select * from pdt3867 where (DATE_BOUGHT BETWEEN '2023-12-04' AND '2024-01-31')
			//OR (DATE_SOLD BETWEEN '2023-12-04' AND '2024-01-31');
			//Creating the query
			String query = "SELECT * FROM "+productId+" WHERE (DATE_BOUGHT BETWEEN '"+boughtDate+"' AND '"+soldDate
					+"') OR (DATE_SOLD BETWEEN '"+boughtDate+"' AND '"+soldDate+"')";
			
			//Executing the Query and Creating the ResultSet Object
			if(st != null) {
				rst = st.executeQuery(query);
			}
			
			while(rst.next()) {
				product = new SalorProductBean();
				product.setRecordno(Integer.parseInt(rst.getString(1)));
				product.setCostPerProduct(Double.parseDouble(rst.getString(2)));
				product.setSpPerProduct(Double.parseDouble(rst.getString(3)));
				product.setQuantityManufactured(Integer.parseInt(rst.getString(4)));
				product.setQuantitySold(Integer.parseInt(rst.getString(5)));
				product.setTotalCostOfProduction(Double.parseDouble(rst.getString(6)));
				product.setTotalSales(Double.parseDouble(rst.getString(7)));
				product.setNetProfit(Double.parseDouble(rst.getString(8)));
				product.setNetLoss(Double.parseDouble(rst.getString(9)));
				product.setDateBought(rst.getString(10));
				product.setDateSold(rst.getString(11));
				productsales[i] = product;
				i++;
			}
			salesReport = new SalorProductBean[i];
			for(int j = 0; j<i; j++) {
				salesReport[j] = productsales[j];
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salesReport;
	}

	@Override
	public SalorProductBean fetchProduct(int recordno,String userId,String productId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Declaring the SalorProductBean class to hold the information about the product
		SalorProductBean product = new SalorProductBean();
		
		try {
			
			//Establishing connection with the Organization's Database
			con = SalorDaoImpl.connectOrgDatabase(userId);
			
			//Creating the Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Creating the String query to fetch the product's record based on the record no
			String query = "SELECT * FROM "+productId+" WHERE RECORD_NO="+recordno;
			
			//Executing the query and generating the resultSet Object
			if(st != null) {
				rst = st.executeQuery(query);
			}
			
			if(rst.next()) {
				product.setRecordno(Integer.parseInt(rst.getString(1)));
				product.setCostPerProduct(Double.parseDouble(rst.getString(2)));
				product.setSpPerProduct(Double.parseDouble(rst.getString(3)));
				product.setQuantityManufactured(Integer.parseInt(rst.getString(4)));
				product.setQuantitySold(Integer.parseInt(rst.getString(5)));
				product.setTotalCostOfProduction(Double.parseDouble(rst.getString(6)));
				product.setTotalSales(Double.parseDouble(rst.getString(7)));
				product.setNetProfit(Double.parseDouble(rst.getString(8)));
				product.setNetLoss(Double.parseDouble(rst.getString(9)));
				product.setDateBought(rst.getString(10));
				product.setDateSold(rst.getString(11));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rst != null) {
					rst.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return product;
	}

}
