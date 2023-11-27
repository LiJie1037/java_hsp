package printStream_;

import java.io.*;
import java.util.Arrays;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 15:27
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器

        out.print("john, hello");
        //因为print底层使用的是write , 所以我们可以直接调用write进行打印/输出
        out.write("韩顺平,你好".getBytes());
        byte[] b = "headfav".getBytes();
        System.out.println(Arrays.toString(b));

        out.close();

        //我们可以去修改打印流输出的位置/设备
        //1. 输出修改成到 "./f1.txt"
        //2. "hello, 韩顺平教育~" 就会输出到 ./f1.txt

        System.setOut(new PrintStream("./f1.txt"));
        System.out.println("hello, 韩顺平教育~");

        PrintWriter printWriter = new PrintWriter(new FileWriter("./f2.txt"));
        printWriter.print("hahahah");
        printWriter.close();
    }
}
