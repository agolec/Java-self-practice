package ticketredo;

public class main {
    public static void main(String[] args){
        ParkedCar car = new ParkedCar("Honda","Civic",
                CarColor.BLUE,"XMLS",120);
        //System.out.println("parked car info: " + car);

        ParkingMeter meter = new ParkingMeter(4,55);
        //System.out.println("\nMeter: " + meter);

        ParkingTicket ticket = new ParkingTicket();

        PoliceOfficer williamAdler = new PoliceOfficer("Will Adler","ECHO-1912");

        if(williamAdler.isCarIllegallyParked(car,meter)){
            ticket = williamAdler.issueTicket(car,meter);
        }
        if(!ticket.getTicketIssued()){
            System.out.println("Ticket was not issued for car: " +
                    "\n" + car + "\n");
            System.out.println("With meter info: "+
                    "\n" + meter + "\n");
        } else {
            System.out.println("Printing details for issued ticket: ");
            System.out.println(ticket);
        }

    }
}
