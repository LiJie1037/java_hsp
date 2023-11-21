package extendedu;

public class Extend1 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.setName("小学生");
        pupil.setAge(10);
        pupil.setScore(90);
        pupil.info();
        pupil.testing();

        System.out.println("------------");
        Graduate graduate = new Graduate();
        graduate.setName("大学生");
        graduate.setAge(20);
        graduate.setScore(100);
        graduate.info();
        graduate.testing();

        System.out.println("------------");
        Sophomore sophomore = new Sophomore();

    }
}
