package com.salor.service;

import com.salor.bean.SalorAccountLogin;
import com.salor.bean.SalorAccountsRegister;
import com.salor.bean.SalorProductBean;

public interface SalorServiceInterface {
	public String registerAccountService(SalorAccountsRegister accReg);
	public String checkUserIdService(String userId);
	public String loginAccountService(SalorAccountLogin accLog);
	public String insertProductService(SalorProductBean pdt);
	public String updateProductService(SalorProductBean pdt);
	public String deleteProductService(SalorProductBean pdt);
	public void visualizeReportService(SalorAccountLogin acclog);
}
