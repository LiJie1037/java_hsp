package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 16:31
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {

        String filepath = "./mytemp";
        File file = new File(filepath);

        if (!file.exists()) {
            System.out.println("没有mytemp");
            if(file.mkdir()) {
                System.out.println("successful");
            } else {
                System.out.println("failed");
            }
        } else {
            System.out.println("mytemp已存在");
        }

        File hello = new File(filepath, "hello.txt");
        if (!hello.exists()) {
            System.out.println("没有hello.txt");
            if(hello.createNewFile()) {
                System.out.println("successful");
            } else {
                System.out.println("failed");
            }
        } else {
            System.out.println("hello.txt已存在");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hello));
        bufferedWriter.write("hello, world");
        bufferedWriter.close();
    }
}
