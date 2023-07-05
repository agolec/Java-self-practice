package main.java.ticketredo;

public class PoliceOfficer {
    /**
     * The PoliceOfficer class should simulate a Police officer
     * Inspecting a parked car.
     *
     * Responsibilities:
     *
     * 1. to know the police officer's name
     * 2. to know the police officer's badge number.
     * 3. to examine a ParkedCar object and a ParkingMeter object and
     *      determine whether the car's time has expired.
     * 4. to issue a parking ticket (generate a ParkingTicket object)
     *      if that car's time has expired.
     */
    private String badgeNumber;
    private String name;
    private ParkingTicket ticket;
    PoliceOfficer(PoliceOfficer sourceOfficer){
        this.badgeNumber = sourceOfficer.badgeNumber;
        this.name = sourceOfficer.name;
        if(sourceOfficer.ticket == null){

        }else {

        }
    }
    PoliceOfficer(String name, String badgeNumber){
        this.name = name;
        this.badgeNumber = badgeNumber;
    }
    public String getName(){
        return this.name;
    }
    public String getBadgeNumber(){
        return this.badgeNumber;
    }
    public void setBadgeNumber(String badgeNumber){
        this.badgeNumber = badgeNumber;
    }
    public boolean isCarIllegallyParked(ParkedCar car,ParkingMeter meter){
        return car.getMinutesParked() > meter.getMinutesOfParkingPurchased();
    }
    public String toString(){
        return "Name: " + this.name +
                "\nBadge Number: " + this.badgeNumber + "\n";
    }
    public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter){
        int MINIMUM_TIME_FOR_FINE = 60;
        int FIRST_HOUR_FINE = 25;
        int FEE_AFTER_FIRST_HOUR = 10;
        int timeOverParked = car.getMinutesParked() - meter.getMinutesOfParkingPurchased();

        if(isCarIllegallyParked(car,meter)){
            this.ticket = new ParkingTicket(car,this);
            this.ticket.setTicketIssued(true);
            if(timeOverParked <= MINIMUM_TIME_FOR_FINE){
                ticket.setFine(FIRST_HOUR_FINE);
            } else {
                double timeInHours = timeOverParked / 60;
                ticket.setFine(FIRST_HOUR_FINE + (FEE_AFTER_FIRST_HOUR * timeInHours));
            }
        }
        return ticket;
    }

}

