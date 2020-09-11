package pruefungsLeistung2;

public class MobileGame extends Game{
	
	OperatingSystem operatingSystem;
	
	public MobileGame(String title, Genre genre, int publishingYear, boolean playedThrough, OperatingSystem oepratingSystem)
	{
		super(title, genre, publishingYear, playedThrough);
		this.operatingSystem = operatingSystem;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}
}
