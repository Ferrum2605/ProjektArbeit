package pruefungsLeistung2;

public enum OperatingSystem {

	MSWINDOWS("MS Windows"), MACOS("macOS"), LINUX("Linux"), IOS("iOS"), ANDROID("Android");
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	OperatingSystem(String description)
	{
		this.description = description;
	}
}
