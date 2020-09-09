package gui;

public enum Currency {
	EURO("Euro", '€'), DOLLAR("Dollar", '$');
	
	private String description;
	private char currencyCode;
	
	Currency(String bezeichnung, char zeichen)
	{
		this.description = bezeichnung;
		this.currencyCode = zeichen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(char currencyCode) {
		this.currencyCode = currencyCode;
	}

}
