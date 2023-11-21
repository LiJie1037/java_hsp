import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*        int[] arr = {1, 2, 3};
        int num1 = arr[0];
        num1 = 8;
        System.out.println(arr[0]);

        String[] names = {"lijei", "gaowenjie"};
        String[] s = names;
        names[0] = "hahah";
        System.out.println(s[0]);
        */

/*        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.deepToString(ns));
        for (int[] arr : ns) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(", ");
            }
            System.out.println();
        }*/

        int[][] arr = new int[3][2];
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j + 1;
            }
        }
        System.out.print(Arrays.deepToString(arr));
        System.out.println();

        int total = 0;
        for (int[] sum : arr) {
            for (int num : sum) {
                total += num;
            }
        }
        System.out.println(total);

        String y[] = {"aa", "bb", "cc"};
//        String d[] = {'a', 'b', 'c'};

    }
}