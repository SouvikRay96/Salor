package com.salor.bean;

public class SalorProductBean {
	private int productId;
	private String productName;
	private double costPerProduct;
	private double spPerProduct;
	private int quantityManufactured;
	private int quantitySold;
	private double totalCostOfProduction;
	private double totalSales;
	private double netProfit;
	private double netLoss;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getCostPerProduct() {
		return costPerProduct;
	}
	public void setCostPerProduct(double costPerProduct) {
		this.costPerProduct = costPerProduct;
	}
	public double getSpPerProduct() {
		return spPerProduct;
	}
	public void setSpPerProduct(double spPerProduct) {
		this.spPerProduct = spPerProduct;
	}
	public int getQuantityManufactured() {
		return quantityManufactured;
	}
	public void setQuantityManufactured(int quantityManufactured) {
		this.quantityManufactured = quantityManufactured;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalCostOfProduction() {
		return totalCostOfProduction;
	}
	public void setTotalCostOfProduction(double totalCostOfProduction) {
		this.totalCostOfProduction = totalCostOfProduction;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	public double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(double netProfit) {
		this.netProfit = netProfit;
	}
	public double getNetLoss() {
		return netLoss;
	}
	public void setNetLoss(double netLoss) {
		this.netLoss = netLoss;
	}
	
}