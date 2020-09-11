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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Model implements Serializable{

	private static Model instance;
	
	private String path = "C:\\Users\\A002520\\Documents\\GitHub\\ProjektArbeit\\Hausarbeit\\src\\pruefungsLeistung2\\game.txt";
	
	private GameList gameList;
	
	public Model() {
		
		try {
			checkFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	/**
	 * Spiel zum Objekt gameList hinzufügen und gameList in File speichern
	 */
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
	 * Spiel aus dem Objekt gameList löschen
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
	 * Die der Methode mitgegebene ArrayList wird in die Datei gespeichert
	 * 
	 */
	public void saveGameListToFile(GameList gameList) throws NotSerializableException {
		File file = new File(path);
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(gameList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Text-Datei wird "resettet", sprich der Inhalt wird gelöscht 
	 */
	
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
	
	/**
	 * Checkt, ob File schon existiert, wenn nicht wird eine neue erstellt. 
	 * Falls die File kein en Inhalt hat wird ein neues Objekt gameList initialisiert
	 *  und in der File gespeichert. HAt die File einen Inhalt wird dieser ausgelesen und mit
	 *  diesem das Objekt gameList initialisiert
	 */
	
	public void checkFile() throws FileNotFoundException {
		File gameListFile = new File(path);
		

		try {
			if (gameListFile.exists() && !gameListFile.isDirectory()) {
				System.out.println("File <game.txt> already exists. Reading content...");
			} else {
				System.out.println("File <game.txt> doesn't exist. Creating " + path);
				gameListFile.createNewFile();
			}
			if (gameListFile.length() == 0) {
				
				gameList = new GameList();
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
	 * Zurückgeben einer Instanz des Models
	 * 
	 */

	//Singleton-Bereich
		public static Model getInstance() {
			if (instance == null) {
				instance = new Model();
			}
			return instance;
		}
		
		/**
		 *  DAs Objekt ...Game wird erstellt, zur gameList hinzugefügt und gespeichert
		 */
		
		public MobileGame generateMobileGame(String title,Genre genre, int publishingYear, boolean playedThrough, OperatingSystem operatingSystem)
		{
			MobileGame g1 = new MobileGame(title, genre, publishingYear, playedThrough, operatingSystem);
			addGameToGameList(g1);
			return g1;
		}
		
		public ConsoleGame generateConsoleGame(String title,Genre genre, int publishingYear, boolean playedThrough, ConsoleSystem consoleSystem)
		{
			ConsoleGame g1 = new ConsoleGame(title, genre, publishingYear, playedThrough, consoleSystem);
			addGameToGameList(g1);
			return g1;
		}
		
		public PCGame generatePCGame(String title,Genre genre, int publishingYear, boolean playedThrough, OperatingSystem operatingSystem, String systemRequirements)
		{
			PCGame g1 = new PCGame(title, genre, publishingYear, playedThrough, operatingSystem, systemRequirements);
			addGameToGameList(g1);
			return g1;
		}
		
	/**
	 * Getter and Setter
	 */
	

	public static void setInstance(Model instance) {
		Model.instance = instance;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}


	public String getPath() {
		return path;
	}

	
	
	
}
