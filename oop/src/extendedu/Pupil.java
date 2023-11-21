package extendedu;

public class Pupil extends Student{
    public Pupil() {
        System.out.println("Pupil constructor is called.");
    }

    public void testing() {
        System.out.println("Pupil "+ name + " is taking a math exam.");
    }
}
