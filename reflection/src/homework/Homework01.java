package homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 20:37
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName("homework.PrivateTest");
        System.out.println(cls.getClass());

        Object o = cls.getDeclaredConstructor().newInstance();

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "hahah");

        Method getName = cls.getMethod("getName");
        System.out.println(getName.invoke(o));
    }
}

class PrivateTest {
    private String name = "hellokitty";
    public String getName() {
        return name;
    }
}