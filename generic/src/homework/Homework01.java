package homework;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 19:27
 */

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *  *
 *  * 分别创建以下方法：
 *  * (1) public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 *  * (2) public T get(String id)：从 map 中获取 id 对应的对象
 *  * (3) public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 *  * (4) public List<T> list()：返回 map 中存放的所有 T 对象
 *  * (5) public void delete(String id)：删除指定 id 对象
 */

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {


    }

    @Test
    public void testList() {
        Dao<User> dao = new Dao<>();
        dao.save("001", new User(1, 20, "mike"));
        dao.save("002", new User(2, 21, "bob"));
        dao.save("003", new User(3, 22, "gina"));

        System.out.println(dao.get("001"));
        dao.update("003", new User(3, 22, "haha"));
        System.out.println(dao.get("003"));

        List list = dao.list();
        System.out.println(list);

        dao.delete("002");

        List list1 = dao.list();
        System.out.println(list1);

    }
}

@SuppressWarnings({"all"})
class Dao<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList();

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}