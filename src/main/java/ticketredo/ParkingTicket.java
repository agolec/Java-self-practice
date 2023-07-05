package main.java.ticketredo;

/**
 *  This class should simulate a parking ticket.
 *
 *  Resonsponsibilities:
 *
 *  1. Report the make, model, color, license plate number of an illegally parked car.
 *
 *  2.To report the amount of the fine
 *      for every hour or part of an hour
 *      that a car is illegally parked.
 *
 *      The Fine -  1.  a $25.00 dollar amount for the first hour.
 *                  2.  $10.00 more dollars every hour or part of
 *                      an hour after the first hour.
 *
 *  3. To report the Name and Badge Number of the reporting officer.
 *
 *
 */
public class ParkingTicket {
    private double fine;
    private ParkedCar car;
    private PoliceOfficer officer;
    private boolean ticketIssued = false;

    ParkingTicket(){

    }
    ParkingTicket(ParkedCar car, PoliceOfficer officer){
        this.car = new ParkedCar(car);
        this.officer = new PoliceOfficer(officer);
    }
    public void setFine(double fine){
        this.fine = fine;
    }
    public double getFine(){
        return fine;
    }
    public void setTicketIssued(boolean ticketIssued){
        this.ticketIssued = ticketIssued;
    }
    public boolean getTicketIssued(){
        return this.ticketIssued;
    }
    public void setParkedCar(ParkedCar car){
        //Need to create a new parked car object to work with.
        //The ParkingTicket need to know information about the
        //Parked Car, so we need to give it a parked car object.
        this.car = new ParkedCar(car);
    }
    public ParkedCar getParkedCar(){
        return this.car;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Car information: \n");
        sb.append(this.car);
        sb.append("Reporting Officer Information: \n\n");
        sb.append(this.officer);
        sb.append("Fine: "+ fine);

        return sb.toString();
    }

}
