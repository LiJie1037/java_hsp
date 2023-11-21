package stringBuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        //1. StringBuffer 的直接父类 是 AbstractStringBuilder
        //2. StringBuffer 实现了 Serializable, 即StringBuffer的对象可以串行化
        //3. 在父类中  AbstractStringBuilder 有属性 char[] value,不是final
        //   该 value 数组存放 字符串内容，引出存放在堆中的
        //4. StringBuffer 是一个 final类，不能被继承
        //5. 因为StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
        //   不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String
        StringBuffer stringBuffer = new StringBuffer("hello");

        StringBuffer stringBuffer1 = new StringBuffer();
        System.out.println(stringBuffer1.length());

        StringBuffer stringBuffer2 = new StringBuffer(100);

        StringBuffer hello = new StringBuffer("hello");

//        StringBuffer -> String
        String strTest = "hi";
        StringBuffer test = new StringBuffer(strTest);
        StringBuffer test2 = new StringBuffer();
        test2.append(strTest);
        System.out.println(test2);
        test2.append(11);
        System.out.println(test2);

//        StringBuffer -> String
        String s = hello.toString();
        System.out.println(s);
        String s1 = new String(hello);
        System.out.println(s1);

    }
}
