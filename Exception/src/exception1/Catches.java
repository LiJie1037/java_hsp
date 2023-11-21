package exception1;

public class Catches {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());

            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;
        } catch (NullPointerException e) {
            System.out.println("空指针异常" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算术异常" + e.getMessage());
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("-------");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("继续");
        }
    }
}

class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}