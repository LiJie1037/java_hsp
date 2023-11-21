public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        int[] arr = {1, 5, 70, 88, 100, 99};
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

            System.out.printf("第%d轮排序后:\n", i+1);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "\t");
            }
            System.out.println();
        }
    }
}