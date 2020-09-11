package pruefungsLeistung2;

public class ConsoleGame extends Game{

	public ConsoleSystem getConsoleSystem() {
		return consoleSystem;
	}

	ConsoleSystem consoleSystem;

	public ConsoleGame(String title, Genre genre, int year, boolean playedThrough, ConsoleSystem consoleSystem)
	{
		super(title, genre, year, playedThrough);
		this.consoleSystem = consoleSystem;
	}

}