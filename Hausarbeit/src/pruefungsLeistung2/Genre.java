package pruefungsLeistung2;

public enum Genre {

	ACTION("Action"), ACTIONADVENTURE("Action-Adventure"), RPG("RPG"), SPORT("Sport"), STRATEGIE("Strategie"), SIMULATION("Simulation");

	private String description;

	Genre(String description)
	{
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
