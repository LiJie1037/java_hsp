package fileBase;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 11:22
 */
public class FileInfomation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        File file = new File("./news.txt");
        System.out.println("file's name = " + file.getName());
        System.out.println("file's absolute file path= " + file.getAbsoluteFile());
        System.out.println("file's parent path= " + file.getParent());
        System.out.println(file.isFile());
        System.out.println("length=" + file.length());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
    }
}
