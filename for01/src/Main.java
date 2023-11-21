public class Main {
    public static void main(String[] args) {
//        int count = 0;
//        int sum = 0;
//        for (int i = 0; i < 100; i++) {
//            if (i % 9 == 0) {
//                count++;
//                sum += i;
//                System.out.println("i = " + i + "\tsum = " + sum + "\tcount = " + count);
//            }
//        }
        int i = 0;
        while (i < 100) {
            if (i % 3 == 0) {
                System.out.println(i);
            }

            i++;
        }
        System.out.println("Hello world!");
    }
}