package homework;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 16:44
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "./news3.txt";
//        BufferedReader br = new BufferedReader(new FileReader(filePath));

        // 出现中文乱码
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));

        String line;
        int rowNum = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(++rowNum + "\t" + line);
        }
        br.close();
    }
}
