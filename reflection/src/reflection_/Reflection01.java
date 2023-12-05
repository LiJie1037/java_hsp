package reflection_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 16:08
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 1.加载 Properties
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("./src/re.properties")));
        String classFullPath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        // 传统方法
//        reflection_.Cat cat = new reflection_.Cat();
//        cat.cry();

        // 反射机制
        Class cls = Class.forName(classFullPath);
        Object o = cls.newInstance();
//        Object o1 = cls.getDeclaredConstructor().newInstance();
        System.out.println("=========");
        System.out.println(o.getClass());
        // 在反射中, 万物皆对象
        Method method = cls.getMethod(methodName);
        method.invoke(o);

        // 字段
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));

        // constructor
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

    }
}
