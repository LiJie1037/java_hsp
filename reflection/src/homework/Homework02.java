package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 20:52
 */
public class Homework02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String filePath = "mynew.txt";
//        File file = new File("./src/reflection_/Cat.java");
//        boolean newFile = file.createNewFile();
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class);
        Object fileObject = declaredConstructor.newInstance("e:\\mynew.txt");
        System.out.println(fileObject);
        Method createNewFile = cls.getMethod("createNewFile");
        createNewFile.invoke(fileObject);
/*        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0 , readLen));
        }*/
    }
}
