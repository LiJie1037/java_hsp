import java.util.Scanner;

/*public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int[] newArr = new int[arr.length + 1];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your number: ");
        int insertNum = scanner.nextInt();
        int idx = -1;

        // 寻找插入位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < insertNum) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = insertNum;
                idx = i;
                break;
            }
        }

        // 插入剩余元素
        for (int j = idx; j < arr.length; j++) {
            newArr[j + 1] = arr[j];
        }

        // 输出新数组
        for (int n : newArr) {
            System.out.print(n + ", ");
        }

        // 关闭Scanner
//        scanner.close();
    }
}*/

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = (int)(Math.random() * 100) + 1;
            arr[i] = num;
        }
        double sum = 0;
        int max = arr[arr.length - 1];
        int idx = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] == 8) {
                System.out.println("\nexist 8");
            }
            sum += arr[i];
        }
        System.out.println();
        System.out.println("Average=" + sum / n );
        System.out.printf("max=%d, index=%d", max, idx);


        char[] arr1 = {'a', 'z', 'b', 'c'};
        char[] arr2 = arr1;
        arr1[2] = '韩';
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr1[i]+ "," + arr2[i]);
        }
    }
}