package com.salor.factory;

import com.salor.service.SalorServiceImpl;
import com.salor.service.SalorServiceInterface;

public class SalorServiceFactory {
	
	private static SalorServiceInterface salorService;
	
	static {
		salorService = new SalorServiceImpl();
	}
	
	public static SalorServiceInterface getSalorServiceObject() {
		return salorService;
	}
}
