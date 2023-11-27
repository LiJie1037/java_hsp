package writer_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 11:48
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String filePath = "./src/屏幕截图.png";
        String destFilePath = "./src/屏幕截图copy.png";

        byte[] buf = new byte[1024];
        int readLen = 0;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(filePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            while((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }

                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
