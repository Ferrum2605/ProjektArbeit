package gui;

public class Option {

	/*
	 * Attribute
	 */
	private int id;
	private String sign;
	private String description;
	private boolean isSelected;

	/*
	 * Methoden
	 */
	public Option(int id, String sign, String description, boolean isSelected) {
		this.id = id;
		this.sign = sign;
		this.description = description;
		this.isSelected = isSelected;
	}

	public int getId() {
		return id;
	}

	public String getSign() {
		return sign;
	}

	public String getDescription() {
		return description;
	}

	public boolean isSelected() {
		return isSelected;
	}

}
