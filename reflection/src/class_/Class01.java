package class_;

import reflection_.Cat;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 16:54
 * 演示Class类
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String classAllPath = "reflection_.Cat";

        // 类的加载方式
        // 1.编译阶段
        Class<?> cls1 = Class.forName("reflection_.Cat");
        System.out.println("cls1=" + cls1);

        // 2.Class 类阶段
        Class<Cat> cls2 = Cat.class;
        System.out.println("cls2=" + cls2);

        // 3. getClass
        Cat cat = new Cat();
        Class<? extends Cat> cls3 = cat.getClass();
        System.out.println("cls3=" + cls3);

        // 4. 类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println("cls4=" + cls4);

        // 5.基本数据类型
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass=" + integerClass);

        // 6.基本数据类型的包装类  TYPE
        Class<Integer> type = Integer.TYPE;
        System.out.println("type=" + type);

    }
}
