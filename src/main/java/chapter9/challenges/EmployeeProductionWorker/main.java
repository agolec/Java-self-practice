package chapter9.challenges.EmployeeProductionWorker;

public class main {
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.setEmployeeNumber("222-M");
        int date = 32;
        emp.setHireDate(1988,2,date);
        System.out.println(emp.getHireDate());

        ProductionWorker pw = new ProductionWorker();
        pw.setShift(3);

        System.out.println("shift is: " + pw.getShift());
    }

}