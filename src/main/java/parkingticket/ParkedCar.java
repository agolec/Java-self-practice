package main.java.parkingticket;

public class ParkedCar {

    private String make;
    private String model;
    private String color;
    private String license;
    private int minutesParked;

    ParkedCar(String name, String make, String model, String color,String license, int minutesParked){
        this.make = make;
        this.model = model;
        this.color = color;
        this.license = license;
        this.minutesParked = minutesParked;

    }
    ParkedCar(){
        this.make = "";
        this.model = "";
        this.color = "";
        this.minutesParked = 0;
    }
    public ParkedCar(ParkedCar sourceParkedCarObject){
        this.make = sourceParkedCarObject.make;
        this.model = sourceParkedCarObject.model;
        this.color = sourceParkedCarObject.color;
        this.minutesParked = sourceParkedCarObject.minutesParked;
    }
    //Getters
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public String getColor(){
        return this.color;
    }
    public int getMinutesParked(){
        return this.minutesParked;
    }
    public String getLicense(){
        return this.license;
    }

    //Setters
    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setLicense(String license){
        this.license = license;
    }
    public void setMinutesParked(int minutesParked){
        this.minutesParked = minutesParked;
    }




}
