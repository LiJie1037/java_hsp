package System_;

import java.util.Arrays;

import static java.lang.System.exit;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 16:23
 */
public class System_ {
    public static void main(String[] args) {

//        System.out.println("ok1");
//        exit(0);
//        System.out.println("ok2");

        int[] src = {1, 2, 3};
        int[] dest = new int[3];

        System.arraycopy(src, 1, dest, 1, 2);
        System.out.println(Arrays.toString(dest));

        System.out.println(System.currentTimeMillis());
    }
}
