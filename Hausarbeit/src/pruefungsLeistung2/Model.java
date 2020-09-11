package pruefungsLeistung2;


public class Model {

	private static Model instance;

	public static Model getInstance() {
		if (instance == null) {
			instance = new Model();
		}
		return instance;
	}
}
