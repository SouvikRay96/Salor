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

public class SalorDaoImpl implements SalorDaoInterface {

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
						+"(COST_PRICE_PER_PRODUCT DOUBLE(7,3),"
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
		}
		return status;
	}

	@Override
	public String updateProduct(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visualizeReport(SalorAccountLogin acclog) {
		// TODO Auto-generated method stub

	}

}
