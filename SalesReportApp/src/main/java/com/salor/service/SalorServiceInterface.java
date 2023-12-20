package com.salor.service;

//import java.util.ArrayList;
//import java.util.List;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;

public interface SalorServiceInterface {
	public String registerAccountService(SalorAccountsRegister accReg);
	public String checkUserIdService(String userId);
	public String checkProductIdService(String productId,String userId);
	public String loginAccountService(SalorAccountLogin accLog);
	public String insertProductService(SalorProductBean pdt,String userId);
	public String insertProductSalesService(SalorProductBean pdt,String userId);
	public String updateProductService(SalorProductBean pdt);
	public String deleteProductService(SalorProductBean pdt);
	public String deleteAllProductDetailsService(String pdtId,String userId);
	public void visualizeReportService(SalorAccountLogin acclog);
	public String[] profileInfoService(String userId);
	public String[] productListService(String userId);
}
