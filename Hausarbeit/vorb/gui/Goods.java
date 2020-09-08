package gui;

import java.io.Serializable;

import supermarkt.ClassOfGoods;
import supermarkt.Currency;

public class Goods implements Serializable {

	/*
	 * Attribute
	 */
	private int id;
	private String description;
	private String classOfGoods;
	private String unit;
	private double price;
	private String currency;

	/*
	 * Methoden
	 */
	public Goods(int id, String description, String classOfGoods, String unit, double price, String currency) {
		
		this.id = id;
		this.description = description;
		this.classOfGoods = classOfGoods;
		this.unit = unit;
		this.price = price;
		this.currency = currency;
		
	}

	public void displayProduct()
	{
		//System.out.println(id + " " + description + " " + classOfGoods.getDescription() + " " + unit + " " + price + currency.getCurrencyCode());
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getClassOfGoods() {
		return classOfGoods;
	}

	public String getCurrency() {
		return currency;
	}


	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	}