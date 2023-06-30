package chapter5.challenges.distancetraveled;

import java.io.PrintWriter;

public class DistanceTraveled {
    int mphOfVehicle = 0;
    int totalNumberOfHoursTraveled = 0;

    DistanceTraveled(int mphOfVehicle,int hoursTraveled){
        this.mphOfVehicle = mphOfVehicle;
        this.totalNumberOfHoursTraveled = hoursTraveled;
    }
    /*
    Returns the distance in miles the vehicle has traveled.
     */
    private int getDistanceTraveledByHourIndex(int hourIndex){
        return mphOfVehicle * (hourIndex + 1);
    }
    public String printDistanceTraveledData(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totalNumberOfHoursTraveled; i++){
            sb.append(i+1 + "\t\t\t\t\t" + String.format("%5d", this.getDistanceTraveledByHourIndex(i)) + "\n");
        }
        return sb.toString();
    }
    public void writeDataToFile(PrintWriter distanceTraveledFile){
        String line = new String();
        for(int i = 0; i < totalNumberOfHoursTraveled; i++){
            distanceTraveledFile.println(i+1 + "\t\t\t\t\t" + String.format("%5d", this.getDistanceTraveledByHourIndex(i)));
        }
        distanceTraveledFile.close();

    }


}
