package CPUNUm;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 12:39
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println(cpuNums);
    }
}
