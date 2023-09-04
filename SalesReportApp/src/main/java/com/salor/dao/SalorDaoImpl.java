package com.salor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;
import com.salor.factory.ConnectionFactory;

public class SalorDaoImpl implements SalorDaoInterface {

	@Override
	public String registerAccount(SalorAccountsRegister accReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUserId(String userId) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
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
