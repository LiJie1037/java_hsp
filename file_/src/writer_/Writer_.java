package writer_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/25 14:16
 */
public class Writer_ {
    public static void main(String[] args) {

    }

    @Test
    public void writer01() {
        String filePath = "note.txt";
        FileWriter fileWriter = null;
        int data = 0;
        int readLen = 0;
        char[] chars = {'a', 'b', 'c'};

        try {
            fileWriter = new FileWriter(filePath);

//            3) write(int):写入单个字符
            fileWriter.write('H');
//            4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
//            6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);
            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
