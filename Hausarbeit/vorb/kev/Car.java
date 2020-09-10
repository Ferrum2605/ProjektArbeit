package kev;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private String brand;
	private String type;
	private String color;
	private boolean isUsed;
	private int hp;
	private char fuel;
	private double price;
	private int previousOwner;
	private int km;
	private int registered;
	private int warranty;

	/**
	 * Car initializes a new car with given properties. Every car needs all
	 * properties.
	 * 
	 * 
	 * @param type
	 * @param color
	 * @param hp
	 * @param fuel
	 * @param price
	 * @param previousOwner
	 * @param km
	 * @param registered
	 * @param warranty
	 */
	public Car(String brand, String type, String color, boolean isUsed, int hp, char fuel, double price,
			int previousOwner, int km, int registered, int warranty) {
		this.brand = brand;
		this.type = type;
		this.color = color;
		this.isUsed = isUsed;
		this.hp = hp;
		this.fuel = fuel;
		this.price = price;
		this.previousOwner = previousOwner;
		this.km = km;
		this.registered = registered;
		this.warranty = warranty;
	}

	/*
	 * 
	 * Getter and Setter
	 * 
	 */

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public char getFuel() {
		return fuel;
	}

	public void setFuel(char fuel) {
		this.fuel = fuel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPreviousOwner() {
		return previousOwner;
	}

	public void setPreviousOwner(int previousOwner) {
		this.previousOwner = previousOwner;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getRegistered() {
		return registered;
	}

	public void setRegistered(int registered) {
		this.registered = registered;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
}
