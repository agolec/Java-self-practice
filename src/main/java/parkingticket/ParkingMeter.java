package main.java.parkingticket;

public class ParkingMeter {
    private int numberOfMinutesPurchased;
    ParkingMeter(int numberOfMinutesPurchased){
        this.numberOfMinutesPurchased = numberOfMinutesPurchased;
    }
    ParkingMeter(ParkingMeter sourceMeterObject){
        this.numberOfMinutesPurchased = sourceMeterObject.numberOfMinutesPurchased;
    }
    ParkingMeter(){
        numberOfMinutesPurchased = 0;
    }
    //Getters
    public int getNumberOfMinutesPurchased(){
        return this.numberOfMinutesPurchased;
    }
    //Setters
    public void setNumberOfMinutesPurchased(int numberOfMinutesPurchased){
        this.numberOfMinutesPurchased = numberOfMinutesPurchased;
    }
}
