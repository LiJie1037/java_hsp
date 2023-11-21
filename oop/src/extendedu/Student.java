package extendedu;

public class Student {
    public String name;
    public int age;
    private double score;

    public Student() {
        System.out.println("Student constructor is called.");
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public void info() {
        System.out.printf("name=%s, age=%d, score=%.2f\n", name, age, score);
    }
}
