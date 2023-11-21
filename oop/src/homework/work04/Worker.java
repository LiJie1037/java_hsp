package homework.work04;

public class Worker extends Employee {
    public Worker(String name, double salary, int day) {
        super(name, salary, day);
    }

    @Override
    public void printSalary() {
        System.out.println("This is a worker:");
        super.printSalary();
    }
}
