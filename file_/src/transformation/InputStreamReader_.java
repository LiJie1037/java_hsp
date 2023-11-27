package transformation;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 15:12
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "./note.txt";
        //解读
        //1. 把 FileInputStream(字节流) 转成 InputStreamReader(字符流)
        //2. 指定编码 gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();

    }


}
