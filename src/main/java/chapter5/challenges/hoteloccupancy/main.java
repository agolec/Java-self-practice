package chapter5.challenges.hoteloccupancy;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many floors the hotel has: ");
        int floors = scanner.nextInt();

        while(floors < 1){
            System.out.println("Error how many floors does the hotel have: ");
        }

        int numberOfRooms = 0;
        int occupiedRooms = 0;
        int vacantRooms = 0;
        double occupancyRate = 0;

        for(int i = 1; i <= floors; i++){
            System.out.printf("How many rooms are on floor %d: ",i);
            numberOfRooms += scanner.nextInt();
            System.out.print("How many rooms are occupied?: ");
            occupiedRooms += scanner.nextInt();
        }
        vacantRooms = numberOfRooms - occupiedRooms;
        occupancyRate = ((double) occupiedRooms / numberOfRooms);

        System.out.println("Your hotel occupancy is as follows:");
        System.out.printf("Total rooms: %d\n", numberOfRooms);
        System.out.println("Occupied rooms: " + occupiedRooms);
        System.out.println("Vacant Rooms: " + vacantRooms);
        System.out.println("Ocupancy Rate: " + occupancyRate);
    }
}
