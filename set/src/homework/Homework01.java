package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 19:43
 */
public class Homework01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧"));
        list.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        for (int i = list.size() - 1; i >= 0 ; i--) {
//            System.out.println(list.get(i));
            News news = (News) list.get(i);
            String title = news.getTitle();
            System.out.println(Homework01.processTitle(title));

        }
    }

    public static String processTitle(String title) {

        if (title == null) {
            return "";
        }

        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        }else {
            return title;
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
