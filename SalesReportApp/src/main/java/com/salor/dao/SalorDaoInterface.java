package com.salor.dao;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;

public interface SalorDaoInterface {
	public String registerAccount(SalorAccountsRegister accReg);
	public String checkUserId(String userId);
	public String checkProductId(String productId,String userId);
	public String loginAccount(SalorAccountLogin accLog);
	public String duplicateProduct(String productName,String userId);
	public String insertProduct(SalorProductBean pdt,String userId);
	public String insertProductSales(SalorProductBean pdt,String userId);
	public SalorProductBean fetchProduct(int recordno,String userId,String productId);
	public String updateProduct(SalorProductBean pdt,String userId);
	public String deleteProduct(SalorProductBean pdt,String userId);
	public String deleteAllProductDetails(String pdtId,String userId);
	public SalorProductBean[] visualizeReport(String pdtId,String userId);
	public String[] profileInfo(String userid);
	public String[] productList(String userId);
	public SalorProductBean[] filterSalesReport(String userId,String productId,String boughtDate,String soldDate);
	
}
