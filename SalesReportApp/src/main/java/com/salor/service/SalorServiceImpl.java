package com.salor.service;

//import java.util.List;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;
import com.salor.dao.SalorDaoInterface;
import com.salor.factory.SalorDaoFactory;

public class SalorServiceImpl implements SalorServiceInterface {

	

	@Override
	public String[] productListService(String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String[] productList = salorDao.productList(userId);
		return productList;
	}

	@Override
	public String registerAccountService(SalorAccountsRegister accReg) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.registerAccount(accReg);
		return status;
	}

	@Override
	public String checkUserIdService(String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.checkUserId(userId);
		return status;
	}

	@Override
	public String[] profileInfoService(String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String[] profileInfo = salorDao.profileInfo(userId);
		return profileInfo;
	}

	@Override
	public String loginAccountService(SalorAccountLogin accLog) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.loginAccount(accLog);
		return status;
	}

	@Override
	public String insertProductService(SalorProductBean pdt,String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.insertProduct(pdt,userId);
		return status;
	}

	@Override
	public String checkProductIdService(String productId, String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.checkProductId(productId, userId);
		return status;
	}

	@Override
	public String updateProductService(SalorProductBean pdt,String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.updateProduct(pdt, userId);
		return status;
	}

	@Override
	public String deleteProductService(SalorProductBean pdt,String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.deleteProduct(pdt,userId);
		return status;
	}

	@Override
	public SalorProductBean[] visualizeReportService(String pdtId,String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		SalorProductBean[] productsales = salorDao.visualizeReport(pdtId, userId);
		return productsales;

	}

	@Override
	public String deleteAllProductDetailsService(String pdtId, String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.deleteAllProductDetails(pdtId, userId);
		return status;
	}

	@Override
	public String insertProductSalesService(SalorProductBean pdt, String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.insertProductSales(pdt, userId);
		return status;
	}

	@Override
	public String duplicateProductService(String productName, String userId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		String status = salorDao.duplicateProduct(productName, userId);
		return status;
	}

	@Override
	public SalorProductBean[] filterSalesReportService(String userId, String productId, String boughtDate,
			String soldDate) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		SalorProductBean[] productsales = salorDao.filterSalesReport(userId, productId, boughtDate, soldDate);
		return productsales;
	}

	@Override
	public SalorProductBean fetchProductService(int recordno,String userId,String productId) {
		SalorDaoInterface salorDao = SalorDaoFactory.getSalorDaoObject();
		SalorProductBean product = salorDao.fetchProduct(recordno,userId,productId);
		return product;
	}

}
