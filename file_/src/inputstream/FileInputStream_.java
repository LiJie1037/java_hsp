package inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 13:04
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /***
     * 演示读取文件
     * read
     */
    @Test
    public void readFile01() {
        String filePath = "./news.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            // Returns: the next byte of data, or -1 if the end of the file is reached.
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void readFile02() {
        String filePath = "./news.txt";
        int readData = 0;
        byte[] buf = new byte[10];
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            // Returns: the next byte of data, or -1 if the end of the file is reached.
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print((String) new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
