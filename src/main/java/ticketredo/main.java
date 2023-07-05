package ticketredo;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ParkedCar car = new ParkedCar("Honda","Civic",
                CarColor.BLUE,"XMLS",120);
        Scanner colorInput = new Scanner(System.in);
        System.out.print("Enter a color input for the next car to make: ");
        String colorString = colorInput.nextLine();
        car.setColor(CarColor.GREEN);


        ParkingMeter meter = new ParkingMeter(4,55);

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
    public boolean isNumeric(String stringToValidate){
        boolean isNumeric = true;
        for(int i = 0; i < stringToValidate.length(); i++){
            if(Character.isDigit(stringToValidate.charAt(i))){
                isNumeric = true;
            } else {
                isNumeric = false;
                break;
            }
        }
        return isNumeric;
    }


}
