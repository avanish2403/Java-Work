package com.company.billing.io;

import javax.swing.JTextField;

public class Product {
	
	private String product_name;
	private String product_price;
	private String product_quantity;
	private String product_tax;
	private String product_description;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_tax() {
		return product_tax;
	}
	public void setProduct_tax(String product_tax) {
		this.product_tax = product_tax;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

}
