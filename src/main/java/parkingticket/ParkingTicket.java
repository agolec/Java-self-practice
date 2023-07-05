package parkingticket;

/**
 * The parking ticket class holds field variables of other classes:
 * ParkedCar and ParkingMeter.
 *
 * Be sure to return new instances of these whenever your main program needs to
 * know something about them.
 */

/**
 * The ParkingTicket class's responsibilities are the following:
 *
 * Report the Make, Model, Color, and License Number of the illegally
 * parked car.
 *
 * Report the amount of the fine ($25 dollars for the first hour or part
 * of an hour the car is parked for, plus $10 for every additional hour.
 *
 * Report the name and badge number of the officer that made the ticket.
 *
 *
 */
public class ParkingTicket {
    private ParkedCar parkedCar;
    private ParkingMeter meter;
    private PoliceOfficer officer;
    int fineAmount;

    ParkingTicket(ParkedCar car, PoliceOfficer officer){
        this.parkedCar = new ParkedCar(car);
        this.officer = new PoliceOfficer(officer);
    }
    ParkingTicket(){
        this.parkedCar = null;
        this.officer = null;
        this.fineAmount = 0;
    }
    ParkingTicket(ParkingTicket sourceTicket){
        this.parkedCar = new ParkedCar(sourceTicket.parkedCar);
        this.officer = new PoliceOfficer(sourceTicket.officer);
    }
    //Setters

    public void setFine(int fine) {
        this.fineAmount = fine;
    }

    public void setParkedCar(ParkedCar car){
        this.parkedCar = new ParkedCar(car);
    }
    public void setParkingMeter(ParkingMeter meter){
        this.meter = new ParkingMeter(meter);
    }
    //Getters
    public ParkedCar getParkedCar(){
        return new ParkedCar(this.parkedCar);
    }
    public int getFine(){
        return this.fineAmount;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Car Parked for: " + parkedCar.getMinutesParked() + " minutes.\n");
        sb.append("Meter Purchased for : " + meter.getNumberOfMinutesPurchased() + " minutes.\n");
        sb.append("Fine is: $" + fineAmount);


        return sb.toString();
    }


}
