package pruefungsLeistung2;

public class ConsoleGame extends Game{

	public ConsoleSystem getConsoleSystem() {
		return consoleSystem;
	}

	ConsoleSystem consoleSystem;

	public ConsoleGame(String title, Genre genre, int publishingYear, boolean playedThrough, ConsoleSystem consoleSystem)
	{
		super(title, genre, publishingYear, playedThrough);
		this.consoleSystem = consoleSystem;
	}

}