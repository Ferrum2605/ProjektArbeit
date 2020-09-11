package pruefungsLeistung2;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Game> gameList;
	
	public GameList()
	{
		gameList = new ArrayList<>();
	}
	
	public void addGame(Game game)
	{
		gameList.add(game);
	}
	
	public void removeGame(Game game)
	{
		gameList.remove(game);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Game> getGameList() {
		return gameList;
	}
	
	
	
	
	
	
	
	
	

}
