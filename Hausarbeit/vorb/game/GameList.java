package game;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Game> games = new ArrayList<>();
	
	public GameList() {

	}
	
	public void appendObject(Game game) {
		games.add(game);
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
}
