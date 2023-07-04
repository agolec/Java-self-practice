package ticketredo;

/**
 * The parked car class is responsible for the following:
 *
 * Know the MAKE, MODEL, COLOR, LICENSE NUMBER, NUMBER OF MINUTES PARKED
 * of a car that is parked.
 */
public class ParkedCar {

    private String make;
    private String model;
    private CarColor color;
    private String licenseNumber;
    private int minutesParked;

    ParkedCar(String make, String model, CarColor color, String licenseNumber, int minutesParked){
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNumber = licenseNumber;
        this.minutesParked = minutesParked;
    }
    ParkedCar(){
        this.make = "";
        this.model = "";
        this.color = CarColor.BLACK;
        this.licenseNumber = "";
        this.minutesParked = 0;
    }
    ParkedCar(ParkedCar sourceCar){
        this.make = sourceCar.make;
        this.model = sourceCar.model;
        this.color = sourceCar.color;
        this.licenseNumber = sourceCar.licenseNumber;
        this.minutesParked = sourceCar.minutesParked;
    }

    //Setters
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(CarColor color) {
        this.color = color;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public void setMinutesParked(int minutesParked) {
        this.minutesParked = minutesParked;
    }

    //Getters
    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public CarColor getColor() {
        return this.color;
    }
    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public int getMinutesParked() {
        return this.minutesParked;
    }
    public String toString(){
        String parkedCar = "Make: " + make +
                "\nModel: " + model +
                "\nColor: " + color +
                "\nLicense Plate #: " + licenseNumber +
                "\nMinutes Parked: " + minutesParked + "\n";

        return parkedCar;
    }

}
