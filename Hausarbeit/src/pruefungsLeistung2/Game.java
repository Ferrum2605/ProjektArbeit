package pruefungsLeistung2;

import java.io.Serializable;

public class Game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String title;
	protected Genre genre;
	protected int publishingYear;
	protected boolean playedThrough;
	
	public Game(String title,Genre genre, int publishingYear, boolean playedThrough)
	{
		this.title = title;
		this.genre = genre;
		this.publishingYear = publishingYear;
		this.playedThrough = playedThrough;
		
	}
		
		public String getTitle() {
		return title;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public boolean isPlayedThrough() {
		return playedThrough;
	}


	

	
		
}
