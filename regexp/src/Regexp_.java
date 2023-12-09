import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 19:16
 */
public class Regexp_ {

    public static void main(String[] args) {
        String content = "1998 年 12 月 8 日，第二代 Java 平台的企业版 J2EE 发布。1999 年 6 月，Sun 公司发布了" +
                "第二代 Java 平台（简称为 Java2）的 3 个版本：J2ME（Java2 Micro Edition，Java2 平台的微型" +
                "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2 平台的" +
                "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2 平台的企业版），应" +
                "用 3443 于基于 Java 的应用服务器。Java 2 平台的发布，是 Java 发展过程中最重要的一个" +
                "里程碑，标志着 Java 的应用开始普及 9889";


        // 1. 创建一个 Pattern 对象
//        Pattern pattern = Pattern.compile("(\\d)(\\d{2})(\\d)");
        Pattern pattern = Pattern.compile("(?<g1>\\d)(\\d{2})(?<g3>\\d)");

        // 2. 创建一个匹配器 Matcher 对象
        Matcher matcher = pattern.matcher(content);

        // 3. 开始循环匹配
        /*
         * matcher.find() 完成的任务 （考虑分组）
         * 什么是分组，比如  (\d\d)(\d\d) ,正则表达式中有() 表示分组,第1个()表示第1组,第2个()表示第2组...
         * 1. 根据指定的规则 ,定位满足规则的子字符串(比如(19)(98))
         * 2. 找到后，将 子字符串的开始的索引记录到 matcher对象的属性 int[] groups;
         *    2.1 groups[0] = 0 , 把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         *    2.2 记录1组()匹配到的字符串 groups[2] = 0  groups[3] = 2
         *    2.3 记录2组()匹配到的字符串 groups[4] = 2  groups[5] = 4
         *    2.4.如果有更多的分组.....
         * 3. 同时记录oldLast 的值为 子字符串的结束的 索引+1的值即35, 即下次执行find时，就从35开始匹配
         *
         * matcher.group(0) 分析
         * 源码:
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *  1. 根据 groups[0]=31 和 groups[1]=35 的记录的位置，从content开始截取子字符串返回
         *     就是 [31,35) 包含 31 但是不包含索引为 35的位置
         *  如果再次指向 find方法.仍然安上面分析来执行
         */
        while (matcher.find()) {
            if (matcher.group(1).equals(matcher.group(3))) {
                System.out.println("找到: " + matcher.group(0));
//                System.out.println("第1组()匹配到的值=" + matcher.group(1));
                System.out.println("第1组()匹配到的值=" + matcher.group("g1"));
                System.out.println("第2组()匹配到的值=" + matcher.group(2));
//                System.out.println("第3组()匹配到的值=" + matcher.group(3));
                System.out.println("第1组()匹配到的值=" + matcher.group("g3"));
            }
//            System.out.println("找到: " + matcher.group(0));
//            System.out.println("第1组()匹配到的值=" + matcher.group(1));
//            System.out.println("第2组()匹配到的值=" + matcher.group(2));
//            System.out.println("第3组()匹配到的值=" + matcher.group(3));
        }

        // Pattern 和 Matcher 的 matches 方法
        String content1 = "aaaaabbbbbcccc";

        boolean matches = Pattern.matches("a+b+", content1);
        System.out.println(matches);

        Pattern pattern1 = Pattern.compile(content1);
        Matcher matcher1 = pattern1.matcher(content1);
        System.out.println(matcher1.matches());

    }

    @Test
    public void homework01() {
        String content = "我....我要....学学学学....编程java!";
//        String regexp = "([\\u0391-\\uFFE5]\\.)";
        String regexp = "\\.";

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");

//        regexp = "(.)\\1+";
//        Pattern pattern1 = Pattern.compile(regexp);
//        Matcher matcher1 = pattern1.matcher(content);
//        content = matcher1.replaceAll("$1");
//        System.out.println(content);

        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
//        while (matcher.find()) {
////            System.out.println(matcher.group(0));
////            System.out.println(matcher.start());
////            System.out.println(matcher.end());
//            System.out.print(content.substring(matcher.start(0), matcher.end() - 1) );
//        }

    }

    @Test
    public void homework02() {
        String content = "2000 年 5 月，JDK1.3、JDK1.4 和 J2SE1.3 相继发布，几周后其" +
                "获得了 Apple 公司 Mac OS X 的工业标准的支持。2001 年 9 月 24 日，J2EE1.3 发" +
                "布。" +
                "2002 年 2 月 26 日，J2SE1.4 发布。自此 Java 的计算能力有了大幅提升";

        content = content.replaceAll("JDK1\\.3", "JDK1\\.4");
        System.out.println(content);
    }

    @Test
    public void homework03() {
        String content = "abc@tsinghua.org.cn";

        if (content.matches("^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$")) {
            System.out.println("满足规则");
        } else {
            System.out.println("不满足");
        }
    }

    @Test
    public void homework04() {
        String content = "-0.9";

        if (content.matches("^[-+]?([1-9]\\d*|0)(\\.*\\d+)?$")) {
            System.out.println("满足规则");
        } else {
            System.out.println("不满足");
        }
    }

    @Test
    public void homework05() {
        String content = "http://www.sohu.com:8080/abc/index.htm";
        String regexp = "^([A-z]+)://([A-z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
//        String[] split = content.split("[:/]");
//        for (String str : split) {
//            System.out.println(str);
//        }
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("协议:" + matcher.group(1));
            System.out.println("域名:" + matcher.group(2));
            System.out.println("端口:" + matcher.group(3));
            System.out.println("文件名:" + matcher.group(4));
        }

    }
}
