package parkingticket;

/**
 * Roles of the police officer class in regard to the ParkingTicket class:
 *
 * - To know the police officer's name and badge number.
 * - To examine the ParkedCar object and ParkingMeter object to determine
 * whether a car's time has expired.
 * - To issue a Parking Ticket if the car's time has expired.
 */
public class PoliceOfficer {
    private String name;
    private String badgeNumber;
    private ParkingTicket ticket;

    PoliceOfficer(String name, String badgeNumber){
        this.name = name;
        this.badgeNumber = badgeNumber;
    }
    PoliceOfficer(PoliceOfficer sourceOfficer){
        this.name = sourceOfficer.name;
        this.badgeNumber = sourceOfficer.badgeNumber;
        //source officer may or may not have a ticket on them.
        //Check for nulls and do nothing if it is null, otherwise, make a new parking ticket.
        if(sourceOfficer.ticket == null){

        } else{
            this.ticket = new ParkingTicket(sourceOfficer.ticket);
        }

    }

    //Getters
    public String getName() {
        return name;
    }
    public String getBadgeNumber() {
        return badgeNumber;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    /**
     *
     * @param parkedCar - the parked car under test.
     * @param meter - The parking meter the car under test is parked at.
     * @return
     */
    public boolean isIllegallyParked(ParkedCar parkedCar,ParkingMeter meter){
        return parkedCar.getMinutesParked() > meter.getNumberOfMinutesPurchased();
    }
    public ParkingTicket generateTicket(ParkedCar car, ParkingMeter meter){
        ParkingTicket ticket = new ParkingTicket(car,this);
        int remainderTime = car.getMinutesParked() - meter.getNumberOfMinutesPurchased();
        if(isIllegallyParked(car,meter)){
            if(remainderTime <= 60){
                ticket.setFine(25);
            } else{
                ticket.setFine(25 + (10 * (remainderTime / 60)));
            }
        }
        return ticket;
    }
    public String toString(){
        String policeOfficer = "";
        if(this.ticket != null){
            policeOfficer = "\nName: " + this.name +
                    "\nBadge Number: " + this.badgeNumber +
                    "\nTicket: " + this.ticket;
        } else {
            policeOfficer = "\nName: " + this.name +
                    "\nBadge Number: " + this.badgeNumber;
        }

        return policeOfficer;
    }
}
