package writer_;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 11:05
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "./news2.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hi hi hi \n");
        bufferedWriter.newLine();
        bufferedWriter.write("hi hi hi \n");
        bufferedWriter.write("hi hi hi \n");
        bufferedWriter.close();

        String out;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        while ((out = bufferedReader.readLine()) != null) {
            System.out.println(out);
        }
        bufferedReader.close();
    }
}
