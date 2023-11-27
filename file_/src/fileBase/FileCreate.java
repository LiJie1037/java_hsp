package fileBase;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 11:04
 */
public class FileCreate {
    public static void main(String[] args) {
    }

    @Test
    public void create01() {
        String filePath = "./news.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void create02() {
        File parentFile = new File(".");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void create03() {
        String parentFile = ".";
        String fileName = "news4.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
