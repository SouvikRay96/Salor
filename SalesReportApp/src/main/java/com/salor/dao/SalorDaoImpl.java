package com.salor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;
import com.salor.factory.ConnectionFactory;

public class SalorDaoImpl implements SalorDaoInterface {

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
			if(count == 1)
				status = "success";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertProduct(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
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
