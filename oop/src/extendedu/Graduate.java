package extendedu;

public class Graduate extends Student{
    public Graduate() {
        System.out.println("Graduate constructor is called.");
    }

    public void testing() {
        System.out.println("Graduate "+ name + " is taking a math exam.");
    }
}

