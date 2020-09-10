package tabelle;

import java.io.Serializable;

public class Option implements Serializable{


	private static final long serialVersionUID = 1L;
	/*
	 * Attribute
	 */
	private int id;
	private String sign;
	private String description;
	private boolean isSelected;
	private String optionAttributes;

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
	
	public String getOptionAttribute() {
		optionAttributes = String.valueOf(id) + " - " + sign + " - " + description + " - " + String.valueOf(isSelected);
		return optionAttributes;
	
	}

}
