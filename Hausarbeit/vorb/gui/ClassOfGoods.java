package gui;

public enum ClassOfGoods {

	BAKERY_PRODUCTS("Backwaren"), DAIRY_PRODUCTS("Milchprodukte"), FRUITS("Obst"), VEGETABLES("Gemüse");
	
	private String description;
	
	ClassOfGoods(String description)
	{
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
