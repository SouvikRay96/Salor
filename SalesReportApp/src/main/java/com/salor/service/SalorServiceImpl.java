package com.salor.service;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;
import com.salor.dao.SalorDaoInterface;
import com.salor.factory.SalorDaoFactory;

public class SalorServiceImpl implements SalorServiceInterface {

	@Override
	public String registerAccountService(SalorAccountsRegister accReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUserIdService(String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		salorDao.checkUserId(userId);
		return null;
	}

	@Override
	public String loginAccountService(SalorAccountLogin accLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertProductService(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProductService(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductService(SalorProductBean pdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visualizeReportService(SalorAccountLogin acclog) {
		// TODO Auto-generated method stub

	}

}
