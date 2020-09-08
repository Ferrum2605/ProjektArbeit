package supermarkt;

import java.util.Scanner;

public class Customer {
	
	private String name;
	private ShoppingCart shoppingCart;
	
	public Customer(String name)
	{
		this.name = name;
		shoppingCart = new ShoppingCart();
	}
	
	public void einkaufen(ShoppingCartItem item)
	{
		shoppingCart.addItem(item);
	}
	
	public void korbAnzeigen()
	{
		System.out.println(" Ihr Warenkorb: ");
		System.out.println();
		shoppingCart.displayShoppingCart();
		
	}

}
