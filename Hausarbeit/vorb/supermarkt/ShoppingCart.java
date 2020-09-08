package supermarkt;

import java.util.ArrayList;

public class ShoppingCart {
	

	private ArrayList<ShoppingCartItem> items = new ArrayList<>();
	
	public void addItem(ShoppingCartItem item)
	{
		items.add(item);
	}
	
	public ArrayList<ShoppingCartItem> getShoppingCartItems()
	{
		return items;
	}
	
	public void displayShoppingCart()
	{
		System.out.println("Ware    Einzelpreis   Menge  Zwischensumme  ");
		for(ShoppingCartItem shoppingCartItem : items)
		{
			shoppingCartItem.displayShoppingCartItem();
		}
		System.out.println();
		System.out.println("Gesamtbetrag: " + gesamtsumme() +"€");
		
		
	}
	
	public double gesamtsumme()
	{
		
		double b = 0;
		for(int i = 0; i < items.size(); i++)
		{
			ShoppingCartItem item = items.get(i);
			double a = item.getSubtotal();
			b+=a;
		}
		
		return b;
	}

}
