package ch07;

public class Car {

	private int carId;
	private String carBrand;
	
	public Car(int carId, String carBrand) {
		this.carId = carId;
		this.carBrand = carBrand;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carBrand=" + carBrand + "]";
	}

	public boolean equals(Object obj) {
		
		if(obj instanceof Car) {
			Car tempCar = (Car)obj;
			String carBrand = tempCar.carBrand;
			if(this.carBrand == tempCar.carBrand) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
