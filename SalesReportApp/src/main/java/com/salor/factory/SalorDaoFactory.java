package com.salor.factory;

import com.salor.dao.SalorDaoImpl;
import com.salor.dao.SalorDaoInterface;

public class SalorDaoFactory {
	private static SalorDaoInterface salorDao;
	
	static {
		salorDao = new SalorDaoImpl();
	}
	
	public static SalorDaoInterface getSalorDaoObject() {
		return salorDao;
	}
}
