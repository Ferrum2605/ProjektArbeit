package kev;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

	private static Model instance;
	private CarList carList;
	private String userDataPath = "." + File.separator + "src" + File.separator + "dev2" + File.separator + "project3"
			+ File.separator + "cars.txt";
	private String makerDataPath = "." + File.separator + "src" + File.separator + "dev2" + File.separator + "project3"
			+ File.separator + "makers.txt";

	private ArrayList<String> makers = new ArrayList<>();
	
	/*
	private String brand;
	private String type;
	private String color;
	private boolean isUsed;
	private int hp;
	private char fuel;
	private double price;
	private int previousOwner;
	private int km;
	private int registered;
	private int warranty;
	 */

	/**
	 * Constructor of Model
	 * 
	 * on model create: check if the file where the data needs to be safed in
	 * exists, if not: create a new one
	 */
	private Model() {
		
		try {
			checkFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getMakers() throws FileNotFoundException {

		File file = new File(makerDataPath);
		Scanner scanner = new Scanner(file);
		makers = new ArrayList<>();

		while (scanner.hasNextLine()) {
			makers.add(scanner.nextLine());
		}

		scanner.close();
		return makers;
	}

	public void addMakers(String maker) throws FileNotFoundException {
		File file = new File(makerDataPath);
		try (FileWriter fileWriter = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fileWriter);) {
			bw.append(maker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Check if the file already exists. If not create a new one. If file is empty
	 * save a CarList Object to that file.
	 * 
	 * @throws FileNotFoundException
	 */
	public void checkFile() throws FileNotFoundException {
		File carListFile = new File(userDataPath);
		File makerFile = new File(makerDataPath);

		try {
			if (carListFile.exists() && !carListFile.isDirectory()) {
				System.out.println("File <cars.txt> already exists. Reading content...");
			} else {
				System.out.println("File <cars.txt> doesn't exist. Creating " + userDataPath);
				carListFile.createNewFile();
			}
			if (makerFile.exists() && !carListFile.isDirectory()) {
				System.out.println("File <makers.txt> already exists. Reading content...");
			} else {
				System.out.println("File <makers.txt> doesn't exist. Creating " + userDataPath);
				makerFile.createNewFile();
			}
			if (carListFile.length() == 0) {
				carList = new CarList();
				Car car = new Car("moritz", "ist", "dumm", true, 2, 'f', 0.99, 276, 50000000, 12, 24);
				carList.addCar(car);
				saveCarListToFile(carList);
			} else {
				try (FileInputStream fis = new FileInputStream(carListFile);
						ObjectInputStream ois = new ObjectInputStream(fis)) {
					carList = (CarList) ois.readObject();
				} catch (EOFException e) {

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add car to the CarList object
	 * 
	 * @param car
	 */
	public void addCarToCarList(Car car) {
		carList.addCar(car);
		try {
			saveCarListToFile(carList);
		} catch (NotSerializableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Remove car from the CarList Object
	 * 
	 * @param car
	 */
	public void removeCarFromCarList(Car car) {
		carList.removeCar(car);
		try {
			saveCarListToFile(carList);
		} catch (NotSerializableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Save recent CarList to a file
	 * 
	 * @param carList
	 * @throws NotSerializableException
	 */
	public void saveCarListToFile(CarList carList) throws NotSerializableException {
		File file = new File(userDataPath);
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(carList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Purge file data Resetting file data to null
	 * 
	 * @throws FileNotFoundException
	 */
	public void purgeCarListData() throws FileNotFoundException {
		File file = new File(userDataPath);

		try {
			if (file.exists() && !file.isDirectory()) {
				FileWriter fw = new FileWriter(file);
				System.out.println("File found. Resetting...");
				fw.write("");
				fw.close();
			} else {
				System.out.println("File not found. Creating a new empty file in " + userDataPath);
				file.createNewFile();
			}
			carList = new CarList();
			saveCarListToFile(carList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Model Instance
	 * 
	 * @return instance (Model)
	 */
	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	/*
	 * Getter and Setter
	 */

	public CarList getCarList() {
		return carList;
	}

	public void setCarList(CarList carList) {
		this.carList = carList;
	}

	public String getUserDataPath() {
		return userDataPath;
	}

	public void setUserDataPath(String userDataPath) {
		this.userDataPath = userDataPath;
	}

	public static void setInstance(Model instance) {
		Model.instance = instance;
	}

}
