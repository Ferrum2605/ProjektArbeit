package game;

import java.io.Serializable;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String player1;
	private String player2;
	private int player1points;
	private int player2points;

	public Game(String player1, String player2, int player1points, int player2points) {
		this.player1 = player1;
		this.player2 = player2;
		this.player1points = player1points;
		this.player2points = player2points;
	}

	public String getGame() {
		String game = "Player1:\n" + "Name: " + this.player1 + "\nPoints: " + this.player1points + "\n" + 
				"Player2:\n" + "Name: " + this.player2 + "\nPoints: " + this.player2points;
		return game;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public int getPlayer1points() {
		return player1points;
	}

	public void setPlayer1points(int player1points) {
		this.player1points = player1points;
	}

	public int getPlayer2points() {
		return player2points;
	}

	public void setPlayer2points(int player2points) {
		this.player2points = player2points;
	}
}
