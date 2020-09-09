package supermarkt;

import java.util.Scanner;

public class Startklasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SuperMarket superMarket = new SuperMarket("Lidl");
		
		Customer customer = new Customer("Jannik");
		
		superMarket.uploadGoods();
		superMarket.displayGoods();
		
		Scanner sc = new Scanner(System.in);
		boolean c=true;
		while(c)
		{
			System.out.println("Welcher Artikel?");
			int a = sc.nextInt();
			System.out.println("Wie viele Einheiten? ");
			int b = sc.nextInt();
			System.out.println("Weiterer Artikel true/false");
			System.out.println();
			c = sc.nextBoolean();
			Goods g = superMarket.getGoodsById(a);
			ShoppingCartItem item = new ShoppingCartItem(g, b);
			customer.einkaufen(item);
		}
		
		customer.korbAnzeigen();
		
		

	}

}
