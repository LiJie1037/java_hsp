package arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 15:07
 */
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, -1, 8, 0, 20};
//        bubble01(arr);
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int n1 = (Integer) o1;
                int n2 = (Integer) o2;
                return n1 - n2;
//                return n2 - n1;
            }
        });

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble01(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void bubble02(int[] arr, Comparator c) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
