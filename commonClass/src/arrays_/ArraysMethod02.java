package arrays_;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 15:26
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1);  // key not found.
        int index = Arrays.binarySearch(arr, 568);
        System.out.println("index=" + index);

        Integer[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));

        Integer[] num = new Integer[]{9, 3, 2};
        Arrays.fill(num, 99);
        System.out.println(Arrays.toString(num));

        //equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123};   //, 567
        //1. 如果arr 和 arr2 数组的元素一样，则方法true;
        //2. 如果不是完全一样，就返回 false
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println("equals=" + equals);

        //asList 将一组值，转换成list
        List asList = Arrays.asList(2, 3, 4, 5, 6, 1);
        System.out.println(asList);
        System.out.println("asList的运行类型是" + asList.getClass());

    }
}
