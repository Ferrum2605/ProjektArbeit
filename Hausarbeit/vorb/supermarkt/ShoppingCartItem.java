package supermarkt;

public class ShoppingCartItem {
	
	private Goods goods;
	private int amount;
	private double subtotal;
	
	public ShoppingCartItem(Goods goods, int amount)
	{
		this.goods=goods;
		this.amount=amount;
		this.subtotal = goods.getPrice()*amount;
	}
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void displayShoppingCartItem()
	{
		
		System.out.println(goods.getDescription() + " " + goods.getPrice() + goods.getCurrency().getCurrencyCode() +  " " + amount + " " + subtotal + goods.getCurrency().getCurrencyCode());
	}
	
	
	
	

}
