package pruefung2;

public class Model {

	private static Model instance;

	private Model() {
	}

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}

}
