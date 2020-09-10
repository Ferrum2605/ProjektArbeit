package tabelle;

import java.util.ArrayList;

public class Model {

	private static Model instance;
	private int id;
	private String sign;
	private String description;
	private boolean isSelected;
	private Option option;
	private ArrayList<Option> options;
	private String optionAttributes;

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

	public void createOption(int id, String sign, String description, boolean isSelected) {
		options = new ArrayList<>();
		this.id = id;
		this.sign = sign;
		this.description = description;
		this.isSelected = isSelected;
		option = new Option(id, sign, description, isSelected);
		options.add(option);
	}

	public Option getOption() {
		return option;
	}

	public String getOptionAttribute() {
		optionAttributes = String.valueOf(id) + " - " + sign + " - " + description + " - " + String.valueOf(isSelected);
		return optionAttributes;
	
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	public void writeObject() {
		
	}
	

}
