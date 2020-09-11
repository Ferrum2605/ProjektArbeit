package pruefungsLeistung2;

import java.io.Serializable;

public class Game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String title;
	protected Genre genre;
	protected int year;
	protected boolean playedThrough;
	
	public Game(String title,Genre genre, int publishingYear, boolean playedThrough)
	{
		this.title = title;
		this.genre = genre;
		this.year = publishingYear;
		this.playedThrough = playedThrough;
		
	}
		
		public String getTitle() {
		return title;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getPublishingYear() {
		return year;
	}

	public boolean isPlayedThrough() {
		return playedThrough;
	}
	
	public void displayGame()
	{
		System.out.println(title);
	}


	

	
		
}
