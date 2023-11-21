package homework.work04;

public class Manager extends Employee {
    private double grade;
    private double bonus;

    public Manager(String name, double salary, int day, double grade, double bonus) {
        super(name, salary, day);
        this.grade = grade;
        this.bonus = bonus;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("This is a manager:");
        System.out.println("name:" + getName() + "\tsalary:" + (bonus + getDay() * getSalary() * getGrade()));
    }
}
