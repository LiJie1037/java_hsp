package reader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 14:16
 */
public class Reader_ {
    public static void main(String[] args) {

    }

    @Test
    public void reader01() {
        String filePath = "news3.txt";
        FileReader fileReader = null;
        int data = 0;
        int readLen = 0;
        char[] buf = new char[8];

        try {
            fileReader = new FileReader(filePath);
//            while ((data = fileReader.read()) != -1) {
//                System.out.print((char)data);
//            }
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
