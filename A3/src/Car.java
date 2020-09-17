
/**
 * @author Raffi Alan Bezirjian
 * This is the pojo class
 */
public class Car {

	private String licenseplate;
	private String carName;
	
	

	public Car(String licenseplate, String carName) {
		super();
		this.licenseplate = licenseplate;
		this.carName = carName;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}
	
	

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car [licenseplate=" + licenseplate + ", carName=" + carName + "]";
	}

	

}
