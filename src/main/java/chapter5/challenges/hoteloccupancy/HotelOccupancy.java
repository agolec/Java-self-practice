package chapter5.challenges.hoteloccupancy;

import utilityMethods.StringUtility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelOccupancy {
    private int numberOfFloors = 0;
    private ArrayList<ArrayList<Integer>> floorsAndRooms;
    HotelOccupancy(int numberOfFloors){
        this.numberOfFloors = numberOfFloors;
        floorsAndRooms = new ArrayList<>(numberOfFloors);
    }
    public void setNumberOfRoomsOnFloor(){

    }
    public void setNumberOfFloors(int numberOfFloors){
        this.numberOfFloors = numberOfFloors;
        floorsAndRooms = new ArrayList<>(numberOfFloors);
        //Initialize each element of floorsAndRooms arraylist to have an arraylist inside of it.
        //This will represent the rooms in a floor.
        for(int i = 0; i < numberOfFloors; i++){
            floorsAndRooms.add(new ArrayList<Integer>());
        }
    }
    public void setNumberOfRooms(ArrayList<Integer> roomsInput){
        Scanner scan = new Scanner(System.in);
        int userInput = 0;
        final int NUMBER_OF_FLOORS = floorsAndRooms.size();
        for(int i = 0; i < NUMBER_OF_FLOORS; i++){
            System.out.print("Enter the number of rooms on floor #" + i+1);
            scan.next();
            if(scan.hasNextInt()){
                userInput = scan.nextInt();
                if(userInput <= 0){
                    System.out.println("ERROR. Input must be positive and greater than 0");
                } else{
                    System.out.println("adding floor info to arraylist: ");
                    floorsAndRooms.get(i).add(userInput);
                }
            } else {
                System.out.print("ERROR: Input was not numberic. Enter another number. ");
                scan.next();
            }

        }
    }
}
