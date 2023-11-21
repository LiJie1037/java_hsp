package polymorphic.polyarr;

public class PolyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];

        persons[0] = new Person("jack", 20);
        persons[1] = new Student("stu1", 10, 90);
        persons[2] = new Student("stu2", 11, 92);
        persons[3] = new Teacher("tec1", 30, 10000);
        persons[4] = new Teacher("tec2", 35, 15000);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());

            if (persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            } else if (persons[i] instanceof Student){
                ((Student) persons[i]).study();
            }
        }


    }
}
