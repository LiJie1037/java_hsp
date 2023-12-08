package service;

import dao.MenuDao;
import domain.Menu;

import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 17:01
 * 完成对menu表的各种操作(通过调用MenuDAO)
 */
public class MenuService {
    private MenuDao menuDao = new MenuDao();

    // 显示所有菜品
    public List<Menu> list() {
        return menuDao.queryMulti("select * from menu", Menu.class);
    }

    // 根据 id 点餐
    public Menu getMenuById(int id) {
        return menuDao.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
