package supermarkt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarket {
	
	private String name;
	private ArrayList<Goods> goods;
	
	public SuperMarket(String name)
	{
		this.name = name;
		goods = new ArrayList<>();
	}
	
	public void uploadGoods() 
	{
		File file =new File("C:\\Users\\Jannik\\git\\ProjektArbeit\\Hausarbeit\\VorbereitungKlausurleistung2test\\supermarkt\\waren.txt");
		
		
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(";");
				int id = Integer.parseInt(tokens[0]);
				String des = tokens[1];
				String st1 = tokens[2];
				ClassOfGoods classOfGoods = null;
				switch(st1)
				{
				case"Backwaren":
					classOfGoods = ClassOfGoods.BAKERY_PRODUCTS;
					break;
				case"Milchprodukte":
					classOfGoods = ClassOfGoods.DAIRY_PRODUCTS;
					break;
				case"Obst":
					classOfGoods = ClassOfGoods.FRUITS;
					break;
				case"Gemüse":
					classOfGoods = ClassOfGoods.VEGETABLES;
					break;
				default:
					System.out.println("ClassOfGoods nicht vorhanden");
					break;
				}
				String unit = tokens[3];
				double price = Double.parseDouble(tokens[4]);
				String st2 = tokens[5];
				Currency currency = null;
				switch(st2)
				{
				case"Euro":
					currency = Currency.EURO;
					break;
				case"Dollar":
					currency = Currency.DOLLAR;
					break;
				default:
					System.out.println("Currency nicht vorhanden");
					
				}
				Goods c = new Goods(id, des, classOfGoods, unit, price, currency);
				goods.add(c);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
	
	}
	
	public void displayGoods()
	{
		System.out.println("Willkommen im " + name);
		System.out.println();
		System.out.println("Unser Sortiment: ");
		System.out.println("ID  Bezeichnung   Warengruppe  Einheit  Preis  ");
		for(Goods good : goods)
		{
			good.displayProduct();
		}
		System.out.println();
	}
	
	public Goods getGoodsById(int a)
	{
		Goods g = goods.get(a-1);
		return g;
	}

}
