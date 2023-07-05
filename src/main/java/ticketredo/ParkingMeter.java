package ticketredo;

/**
 * The ParkingMeter class simulates a parking meter.
 *
 * It's responsibility is:
 *
 *      - Know the number of minutes of parking time
 *      that has been purchased in the parking space.
 */
public class ParkingMeter {

    private int minutesOfParkingPurchased;
    private int meterNumber;
    ParkingMeter(){
        minutesOfParkingPurchased = 0;
        meterNumber = 0;
    }
    ParkingMeter(int meterNumber, int timePurchasedAtMeter){
        this.meterNumber = meterNumber;
        this.minutesOfParkingPurchased = timePurchasedAtMeter;
    }
    //Getters
    public int getMinutesOfParkingPurchased() {
        return minutesOfParkingPurchased;
    }
    public int getMeterNumber(){
        return this.meterNumber;
    }
    //Setters
    public void setMinutesOfParkingPurchased(int minutesOfParkingPurchased) {
        this.minutesOfParkingPurchased = minutesOfParkingPurchased;
    }
    public void setMeterNumber(int meterNumber){
        this.meterNumber = meterNumber;
    }
    public String toString(){
        String parkingMeter = "Meter Number: " + this.meterNumber +
                "\nNumber of minutes purchased at Parking Meter: " + getMinutesOfParkingPurchased();

        return parkingMeter;
    }
}
