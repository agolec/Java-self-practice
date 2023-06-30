package chapter5.challenges.distancetraveled;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int totalDistanceOfTrip = 0;
        int numberOfHoursInTrip = 0;
        FileWriter fw = new FileWriter("src//main//java//chapter5//challenges//distancetraveled//data//output.txt");

        totalDistanceOfTrip = validateTotalDistanceInput(sc);
        System.out.println("Successfully gathered distance information");
        numberOfHoursInTrip = validateTotalHoursInput(sc);
        System.out.println("Successfully gathered time information.");

        DistanceTraveled dt = new DistanceTraveled(totalDistanceOfTrip,numberOfHoursInTrip);
        printTableHead();
        System.out.println(dt.printDistanceTraveledData());
        System.out.println("done printing to screen.");

        System.out.println("Writing to file");
        dt.writeDataToFile(fw.getPrintWriter());
        System.out.println("Done printing to file.");


    }

    private static int validateTotalDistanceInput(Scanner sc) {
        int totalDistanceOfTrip = 0;
        System.out.print("Enter a number for the average speed of the vehicle: ");
        totalDistanceOfTrip = sc.nextInt();
        while (totalDistanceOfTrip <= 0) {
            System.out.print("ERROR: Enter a positive number for Total Distance of the trip: ");
            totalDistanceOfTrip = sc.nextInt();
        }
        return totalDistanceOfTrip;
    }
    private static int validateTotalHoursInput(Scanner sc){
        int totalHoursOfTrip = 0;
        System.out.print("Enter a number for the total amount of time traveled: ");
        totalHoursOfTrip = sc.nextInt();
        while(totalHoursOfTrip <= 0){
            System.out.print("ERROR: Enter a positive number for time traveled: ");
            totalHoursOfTrip = sc.nextInt();
        }
        return totalHoursOfTrip;
    }

    public static void printTableHead(){
        System.out.println("Hour\t\t\t\tDistanceTraveled");
        System.out.println("----------------------------------------------------");
    }
    //directory = src/main/java/chapter5/challenges/distancetraveled/data/output.txt
}
