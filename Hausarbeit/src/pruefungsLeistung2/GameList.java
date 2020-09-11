package pruefungsLeistung2;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	private ArrayList<ConsoleGame> gameList;
	
	public GameList()
	{
		gameList = new ArrayList<>();
	}
	
	public void addGame(ConsoleGame game)
	{
		gameList.add(game);
	}
	
	public void removeGame(ConsoleGame game)
	{
		gameList.remove(game);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<ConsoleGame> getGameList() {
		return gameList;
	}
	
	public void displayGameList()
	{
		for(ConsoleGame g : gameList)
		{
			System.out.println(g.getTitle());
		}
	}
	
	
	
	
	
	
	
	
	

}
