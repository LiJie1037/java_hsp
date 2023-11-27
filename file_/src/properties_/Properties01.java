package properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 15:54
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        String src = "./src/mysql.properties";
        BufferedReader br = new BufferedReader(new FileReader(src));

        String line = "";
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            String[] split = line.split("=");
            System.out.println(Arrays.toString(split));
        }

        br.close();
    }
}
