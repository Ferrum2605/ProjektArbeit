package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Model {

	private static Model instance;
	private GameList gameList = new GameList();
	private String playerNameOne;
	private String playerNameTwo;
	private String userDataPath = "." + File.separator + "src" + File.separator + "dev2" + File.separator + "project2"
			+ File.separator + "users.txt";

	private Game game;
	
	final String fieldsNotFilled = "Please fill in both fields.";

	private Model() {
		try {
			checkFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void checkFile() throws FileNotFoundException {
		File file = new File(userDataPath);

		try {
			if (file.exists() && !file.isDirectory()) {
				System.out.println("File already exists. Deleting it's contents...");

				// FileWriter fileWriter = new FileWriter(file);
				// fileWriter.write("");
				// fileWriter.close();
			} else {
				System.out.println("File doesn't exist. Creating " + userDataPath);
				file.createNewFile();
			}
			if (file.length() == 0) {
				gameList = new GameList();
				saveGameListToFile(gameList);
			} else {
				try (FileInputStream fis = new FileInputStream(file);
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

	public void createGame(String player1, String player2) throws NotSerializableException {

		Random rd = new Random();
		int valueOne = rd.nextInt(6) + 1;
		int valueTwo = rd.nextInt(6) + 1;

		this.playerNameOne = player1;
		this.playerNameTwo = player2;

		game = new Game(player1, player2, valueOne, valueTwo);
		gameList.appendObject(game);

		saveGameListToFile(gameList);

		System.out.println(game);
	}
	
	public Game getGame() {
		return this.game;
	}

	public void saveGameListToFile(Object object) throws NotSerializableException {
		File file = new File(userDataPath);
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Game> showAllGames() {
		ArrayList<Game> games = gameList.getGames();
		
		return games;
	}

	public void setPlayerOneName(String playerNameOne) {
		this.playerNameOne = playerNameOne;
	}

	public void setPlayerTwoName(String playerNameTwo) {
		this.playerNameTwo = playerNameTwo;
	}

	public String getPlayerOneName() {
		return this.playerNameOne;
	}

	public String getPlayerTwoName() {
		return this.playerNameTwo;
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

}
