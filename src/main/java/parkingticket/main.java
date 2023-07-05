package main.java.parkingticket;

public class main {
    public static void main(String[] args){
        simulate();
    }
    public static void simulate(){
        ParkedCar car = new ParkedCar();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setColor("BRO");
        car.setMinutesParked(40);
        car.setLicense("XMV-293");

        ParkingMeter meter = new ParkingMeter();
        meter.setNumberOfMinutesPurchased(60);

        PoliceOfficer officer = new PoliceOfficer("bob barker","12LMNOP");

        if(officer.isIllegallyParked(car,meter)){
            ParkingTicket ticket = officer.generateTicket(car,meter);
            System.out.println("Ticket generated.");

            ticket.setParkedCar(car);
            ticket.setParkingMeter(meter);

            System.out.println(ticket);
        } else{
            System.out.println("No ticket needed.");
        }

    }
}
