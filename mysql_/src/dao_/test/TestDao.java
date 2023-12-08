package dao_.test;

import dao_.dao.ActorDao;
import dao_.dao.GoodsDao;
import dao_.domain.Actor;
import dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 10:52
 */
public class TestDao {
    @Test
    public void testActorDao() {
        ActorDao actorDao = new ActorDao();

        //1. 查询多行记录
        List<Actor> actors = actorDao.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println(actors);

        //2. 查询单行记录
        Actor actor = actorDao.querySingle("select * from actor where id = ?", Actor.class, 3);
        System.out.println("====查询单行结果====");
        System.out.println(actor);

        //3. 查询单行单列
        Object o = actorDao.queryScalar("select name from actor where id = ?", 3);
        System.out.println("====查询单行单列值===");
        System.out.println(o);

        //4. dml操作  insert ,update, delete
        int update = actorDao.update("insert into actor values(null, ?, ?, ?, ?)", "张无忌", "男", "2000-11-11", "999");

        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }

    @Test
    public void testGoodsDao() {
        GoodsDao goodsDao = new GoodsDao();

        //1. 查询多行记录
        List<Goods> goodses = goodsDao.queryMulti("select * from goods where id >= ?", Goods.class, 10);
        System.out.println(goodses);

        //2. 查询单行记录
        Goods goods = goodsDao.querySingle("select * from goods where id = ?", Goods.class, 30);
        System.out.println("====查询单行结果====");
        System.out.println(goods);

        //3. 查询单行单列
        Object o = goodsDao.queryScalar("select goods_name from goods where id = ?", 10);
        System.out.println("====查询单行单列值===");
        System.out.println(o);

        //4. dml操作  insert ,update, delete
        int update = goodsDao.update("insert into goods values(null, ?, ?)", "小米手机", "2999");

        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }
}
