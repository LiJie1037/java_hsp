package outputstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 13:48
 */
public class FileCopy_ {
    public static void main(String[] args) {

    }

    @Test
    public void copy01() {
        String srcFilePath = "./news2.txt";
        String destFilePath = "./news2copy.txt";

//        new File("./dest").mkdir();

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        byte[] buf = new byte[8];
        int readLen = 0;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath, true);

            while ((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
