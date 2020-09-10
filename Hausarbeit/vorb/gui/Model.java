package gui;

import java.util.ArrayList;

public class Model {
	
	/*
	 * Singleton-Bereich
	 */
	private static Model instance;

	private Model() {
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}
	
	SuperMarket superMarket = new SuperMarket("Aldi");
	ArrayList<Goods> g2 = new ArrayList<>();
	ArrayList<Goods> goods = new ArrayList<>();
	
	
	public Goods zurueck()
	{
		Goods good = null;
		goods = superMarket.uploadGoods();
		
		for(int i = goods.size()-1; i>0; i-- )
		{
			
			good = goods.get(i);
			good.displayProduct();
			goods.remove(i);
			goods.get(i).displayProduct();
			
		}
		
		return good;
	}
	
	public boolean checkArrayList()
	{
		if(goods.size()>0)
		{
			System.out.println("wahr");
			return true;
		}
		else
		{
			System.out.println("falsch");
			return false;
		}
		
	}

	
	public void sp()
	{
		superMarket.save(g2);
	}
	
	public Goods addGoods(int id, String description, String classOfGoods, String unit, double price, String currency)
	{
		Goods g1 = new Goods(id, description, classOfGoods, unit, price, currency);
		g2.add(g1);
		
		return g1;
	}
	

}
