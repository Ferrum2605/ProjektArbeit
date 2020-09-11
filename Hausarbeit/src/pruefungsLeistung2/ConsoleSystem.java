package pruefungsLeistung2;

public enum ConsoleSystem {

	PS4("PS4", "PlayStation 4"), XONE("XONE", "XBOX One"), SWITCH("Switch", "Nintendo Switch");
	
	private String abbreviation;
	private String description;
	
	ConsoleSystem(String abbreviation, String description)
	{
		this.abbreviation=abbreviation;
		this.description=description;
	}
}

