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

}
