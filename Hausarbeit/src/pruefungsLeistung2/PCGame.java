package pruefungsLeistung2;

public class PCGame extends Game{
	
	

	private OperatingSystem operatingSystem;
	private String systemRequirements;
	
	public PCGame(String title,Genre genre, int publishingYear, boolean playedThrough, OperatingSystem operatingSystem, String systemRequirements)
	{
		super(title, genre, publishingYear, playedThrough);
		
		this.operatingSystem = operatingSystem;
		this.systemRequirements = systemRequirements;
	}
	
	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public String getSystemRequirements() {
		return systemRequirements;
	}
	
	
	

}
