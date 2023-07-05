package ticketredo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    public ParkedCar(String make, String model, CarColor color, String licenseNumber, int minutesParked){
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
    public void setColor(String color){
        while(isValidSelection(color) == false){
            System.out.print("Color is invalid selection. Re-enter.");
            color = getNewInputForColor();
        }
        String colorCheck = color.toUpperCase();
        switch(colorCheck){
            case "RED":
                this.color = CarColor.RED;
                break;
            case "ORANGE":
                this.color = CarColor.ORANGE;
                break;
            case "YELLOW":
                this.color = CarColor.YELLOW;
                break;
            case "GREEN":
                this.color = CarColor.GREEN;
                break;
            case "BLUE":
                this.color = CarColor.BLUE;
                break;
            case "PURPLE":
                this.color = CarColor.PURPLE;
                break;
            case "PINK":
                this.color = CarColor.PINK;
                break;
            case "GREY":
            case "GRAY":
                this.color = CarColor.GREY;
                break;
            case "WHITE":
                this.color = CarColor.WHITE;
                break;
            case "BLACK":
                this.color = CarColor.BLACK;
                break;
                default:
                System.out.println("Incorrect selection.");
                break;
        }
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

    /**If the user has entered the name of a string inside of the colors ArrayList,
    set validString = true.

    Return from this method with the validString boolean. That boolean should only be set inside the
    loop on the condition that the user entered an existing color string.
     **/
    private boolean isValidSelection(String color){
        boolean validString = false;
        ArrayList<String> colors = new ArrayList<String>(
                Arrays.asList("RED","ORANGE","YELLOW",
                        "GREEN","BLUE","PURPLE",
                        "PINK","WHITE","BLACK",
                        "GREY", "GRAY","BROWN"));
        final int COLOR_LIST_SIZE = colors.size();
       for(int i = 0; i < COLOR_LIST_SIZE;i++){
           //System.out.println("colors list: \n'" + colors.get(i) + "'\n" + "User color: \n'" + color.toUpperCase().trim()+"'");
           if(colors.get(i).equals(color.toUpperCase().trim())){
               validString = true;
               break;
           }
       }
        return validString;
    }
    private String getNewInputForColor(){
        Scanner colorString = new Scanner(System.in);
        System.out.print("Enter a color: ");
        return colorString.nextLine();


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
