package homework.work13;

public class Work13 {
    public static void main(String[] args) {
        /*Teacher teacher = new Teacher("张飞", '男', 30, 5);
        teacher.printInfo();

        System.out.println("-----------------------------------");
        Student student = new Student("小明", '男', 15, "00023102");
        student.printInfo();*/

        Person[] persons = new Person[4];
        persons[0] = new Student("jack", '男', 10, "0001");
        persons[1] = new Student("mary", '女', 20, "0002");
        persons[2] = new Teacher("smith", '男', 36, 5);
        persons[3] = new Teacher("scott", '男', 26, 1);

        Work13 work = new Work13();
        System.out.println("-------排序前-----------");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
        }

        work.bubble(persons);
        System.out.println("-------排序后-----------");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
        }
        for (int i = 0; i < persons.length; i++) {
            work.test(persons[i]);
        }
    }

    public void test(Person person) {
        if (person instanceof Student) {
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        } else {
            System.out.println("do nothing");
        }
    }

    public void bubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getAge() < persons[j + 1].getAge()) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }
}
