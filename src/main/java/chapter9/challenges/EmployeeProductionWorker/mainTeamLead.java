package chapter9.challenges.EmployeeProductionWorker;

public class mainTeamLead {
    public static void main(String[] a){
        TeamLeader lead = new TeamLeader(1);
        System.out.println("hours of training done: " + lead.getHoursOfTrainingAttended());
        System.out.println("Bonus: " + lead.getBonus());
        System.out.println("Shift: " + lead.getShiftString());
    }
}
