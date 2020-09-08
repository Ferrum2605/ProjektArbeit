package gui;

public class Goods {

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

	public String getClassOfGoods() {
		return classOfGoods;
	}

	public String getUnit() {
		return unit;
	}

	public double getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public int getId() {
		return id;
	}

	
	public String getDescription() {
		return description;
	}
	


}
