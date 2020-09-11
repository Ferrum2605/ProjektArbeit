package pruefungsLeistung2;

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
	
	
	
	private ArrayList<String> games = new ArrayList<>();
	
	private String path = "C:\\Users\\A002520\\Documents\\GitHub\\ProjektArbeit\\Hausarbeit\\src\\pruefungsLeistung2\\game.txt";
	
	private GameList gameList;
	
	private Model() {
		
		try {
			checkFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	
	
	public ArrayList<String> getGameList() throws FileNotFoundException {

		File file = new File(path);
		Scanner scanner = new Scanner(file);
		games = new ArrayList<>();

		while (scanner.hasNextLine()) {
			games.add(scanner.nextLine());
		}

		scanner.close();
		return games;
	}
	
	public void addGames(String game) throws FileNotFoundException {
		File file = new File(path);
		try (FileWriter fileWriter = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fileWriter);) {
			bw.append(game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addGameToGameList(Game game) {
		gameList.addGame(game);
		try {
			saveGameListToFile(gameList);
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
	public void removeGameFromGameList(Game game) {
		gameList.removeGame(game);
		try {
			saveGameListToFile(gameList);
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
	public void saveGameListToFile(GameList gameList) throws NotSerializableException {
		File file = new File(path);
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(gameList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void purgeGameListData() throws FileNotFoundException {
		File file = new File(path);

		try {
			if (file.exists() && !file.isDirectory()) {
				FileWriter fw = new FileWriter(file);
				System.out.println("File found. Resetting...");
				fw.write("");
				fw.close();
			} else {
				System.out.println("File not found. Creating a new empty file in " + path);
				file.createNewFile();
			}
			gameList = new GameList();
			saveGameListToFile(gameList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void checkFile() throws FileNotFoundException {
		File gameListFile = new File(path);
		

		try {
			if (gameListFile.exists() && !gameListFile.isDirectory()) {
				System.out.println("File <game.txt> already exists. Reading content...");
			} else {
				System.out.println("File <game.txt> doesn't exist. Creating " + path);
				gameListFile.createNewFile();
			}
			/*
			if (makerFile.exists() && !carListFile.isDirectory()) {
				System.out.println("File <makers.txt> already exists. Reading content...");
			} else {
				System.out.println("File <makers.txt> doesn't exist. Creating " + userDataPath);
				makerFile.createNewFile();
			}
			*/
			if (gameListFile.length() == 0) {
				gameList = new GameList();
				//G = new Car("moritz", "ist", "dumm", true, 2, 'f', 0.99, 276, 50000000, 12, 24);
				//gameList.addGame(game);
				saveGameListToFile(gameList);
			} else {
				try (FileInputStream fis = new FileInputStream(gameListFile);
						ObjectInputStream ois = new ObjectInputStream(fis)) {
					gameList = (GameList) ois.readObject();
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
	public void addCarToCarList(Game game) {
		gameList.addGame(game);
		try {
			saveGameListToFile(gameList);
		} catch (NotSerializableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public static void setInstance(Model instance) {
		Model.instance = instance;
	}



	public void setGames(ArrayList<String> games) {
		this.games = games;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}



	public ArrayList<String> getGames() {
		return games;
	}



	public String getPath() {
		return path;
	}



	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}
}
