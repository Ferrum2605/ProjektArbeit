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
	public Goods zurueck()
	{
		Goods good = null;
		ArrayList<Goods> goods = superMarket.uploadGoods();
		for(int i = 0; i<1; i++ )
		{
			
			good = goods.get(i);
		}
		
		return good;
	}


}
