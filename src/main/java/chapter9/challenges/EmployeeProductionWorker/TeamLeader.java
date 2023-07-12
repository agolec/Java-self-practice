package chapter9.challenges.EmployeeProductionWorker;

/**
 * In a particular factory, a team leader is an hourly paid producton worker who leads a small team.
 * In addition to hourly pay, team leaders earn a fixed monthly bonus. Team leaders are required to
 * attend a minimum number of hours of training per year.
 *
 * Write a program that inherits the ProductionWorker class you designed in Programming Challenge 1. the TeamLeader
 * class should have fields for the monthly bonus amount, the required number of training hours, and the
 * number of training hours the Team Leader has attended.
 *
 * Write one or more constructors and appropriate mutators and accessors methods for the class.
 *
 * Demonstrate the class by writing a program that makes TeamLeader objects.
 */
public class TeamLeader extends ProductionWorker {
    private double bonus;
    private double BONUS_INCREMENT = 1000;
    private int hoursOfTrainingAttended;
    private final int REQUIRED_TRAINING_HOURS_TO_ATTEND = 4;
    TeamLeader(){
        super();
        bonus = 0;
        hoursOfTrainingAttended = 0;
    }
    TeamLeader(int shift){
        super(shift);
        bonus = 0;
        hoursOfTrainingAttended = 0;
    }
    TeamLeader(int bonus, int hoursOfTrainingAttended){
        this.bonus = BONUS_INCREMENT;
        this.hoursOfTrainingAttended =hoursOfTrainingAttended;
    }
    //Setters
    public void setBonus(){
        this.bonus += BONUS_INCREMENT;
    }
    public void setHoursOfTrainingAttended(int hoursOfTrainingToIncrement){
        this.hoursOfTrainingAttended += hoursOfTrainingToIncrement;
    }
    //Getters
    public double getBonus(){
        return this.bonus;
    }
    public int getHoursOfTrainingAttended(){
        return this.hoursOfTrainingAttended;
    }

}
