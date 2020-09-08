package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;






public class SuperMarket {
	
	private String name;
	private ArrayList<Goods> goods;
	
	File file =new File("C:\\Users\\Jannik\\git\\ProjektArbeit\\Hausarbeit\\vorb\\gui\\waren.txt");
	
	public SuperMarket(String name)
	{
		this.name = name;
		goods = new ArrayList<>();
	}
	
	public ArrayList<Goods> uploadGoods() 
	{
	
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			while (true) {
				Goods go = (Goods) ois.readObject();
				this.goods.add(go);
			}
		} catch (EOFException e) {
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return goods;
		
	}
	
	public void writeGoods(Goods g)
	{
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(g);
		} catch (IOException e) {
			e.printStackTrace();
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
