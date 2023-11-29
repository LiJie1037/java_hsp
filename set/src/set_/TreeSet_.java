package set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 18:29
 */
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
//        TreeSet treeSet = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((String)o1).length() - ((String)o2).length();
//            }
//        });

        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
//        treeSet.add(null); 不能放入null


        System.out.println(treeSet);
    }
}
