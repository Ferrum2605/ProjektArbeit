package supermarkt;

public class Goods {
	


	private int id;
	private String description;
	private ClassOfGoods classOfGoods;
	private String unit;
	private double price;
	private Currency currency;
	
	public Goods(int id, String des, ClassOfGoods clOfGo, String unit, double price, Currency currency)
	{
		this.id = id;
		this.description = des;
		this.classOfGoods = clOfGo;
		this.unit = unit;
		this.price = price;
		this.currency = currency;
		
	}
	
	public void displayProduct()
	{
		System.out.println(id + " " + description + " " + classOfGoods.getDescription() + " " + unit + " " + price + currency.getCurrencyCode());
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

	public ClassOfGoods getClassOfGoods() {
		return classOfGoods;
	}

	public void setClassOfGoods(ClassOfGoods classOfGoods) {
		this.classOfGoods = classOfGoods;
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	

}
