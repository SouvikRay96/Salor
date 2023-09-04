package com.salor.bean;

public class SalorAccountsRegister {
	
	//Salor Accounts details
	private String userId;
	private String orgName;
	private String emailId;
	private String address;
	private String orgSize;
	private String ownerName;
	private String password;
	
	
	public SalorAccountsRegister(String userId, String orgName, String emailId, String address, String orgSize,
			String ownerName, String password) {
		super();
		this.setUserId(userId);
		this.setOrgName(orgName);
		this.setEmailId(emailId);
		this.setAddress(address);
		this.setOrgSize(orgSize);
		this.setOwnerName(ownerName);
		this.setPassword(password);
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrgSize() {
		return orgSize;
	}
	public void setOrgSize(String orgSize) {
		this.orgSize = orgSize;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
