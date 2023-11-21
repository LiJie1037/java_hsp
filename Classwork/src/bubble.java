import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] arr = {4, 50, 8, 19, 49};
        Mytools tool = new Mytools();
        tool.bubblesort(arr);
        System.out.println("最终的结果：" + Arrays.toString(arr));
    }
}

class Mytools {
    public void bubblesort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!flag) {
                break;
            }
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println("第" + (i + 1) + "轮排序后:" + Arrays.toString(arr));
        }
    }
}