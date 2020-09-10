package kev;

import java.io.Serializable;
import java.util.ArrayList;

public class CarList implements Serializable {
	
	/**
	 *  Add serial version UID 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Car> carList;

	/**
	 * CarList class stores cars that are currently in stock
	 */
	public CarList() {
		carList = new ArrayList<>();
	}
	
	public ArrayList<Car> getCarList() {
		return carList;
	}
	
	/**
	 * addCar method adds a given car to the carList
	 * 
	 * @param car
	 */
	public void addCar(Car car) {
		carList.add(car);
	}
	
	/**
	 * removeCar method removes a given car from carList 
	 * 
	 * @param car
	 */
	public void removeCar(Car car) {
		carList.remove(car);
	}
}
