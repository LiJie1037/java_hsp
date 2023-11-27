package outputstream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 13:28
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void write01() {
        String filePath = "news2.txt";
        File file = new File(filePath);
        byte[] buf = new byte[]{'h', 'l', 'l'};

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file, true);
            String str = "\thello,world2";
            fileOutputStream.write(str.getBytes());
//            fileOutputStream.write(buf, 0, buf.length);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
