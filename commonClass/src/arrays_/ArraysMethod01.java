package arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod01 {
    public static void main(String[] args) {
        // 输出
        Integer[] arr = {1, 20, 100, 90};
        // System.out.println(Arrays.stream(integers).toList());
        System.out.println(Arrays.toString(arr));

        // sort,可以传入Comparator接口的匿名内部类，实现compare方法，自定排序规则
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
