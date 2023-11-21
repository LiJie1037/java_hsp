package collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 21:10
 */
public class Collection01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //1. 集合主要是两组(单列集合 , 双列集合)
        //2. Collection 接口有两个重要的子接口 List Set , 他们的实现子类都是单列集合
        //3. Map 接口的实现子类 是双列集合，存放的 K-V

        //Collection
        //Map

        // 数据单列
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");

        // 数据双列
        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");
        hashMap.put("NO2", "上海");
    }
}
