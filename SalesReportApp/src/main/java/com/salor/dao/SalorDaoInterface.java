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
	public String updateProduct(SalorProductBean pdt);
	public String deleteProduct(SalorProductBean pdt);
	public String deleteAllProductDetails(String pdtId,String userId);
	public void visualizeReport(SalorAccountLogin acclog);
	public String[] profileInfo(String userid);
	public String[] productList(String userId);
	
}
