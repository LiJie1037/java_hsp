package service;

import dao.DiningTableDao;
import domain.DiningTable;

import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 16:11
 */
public class DiningTableService {

    private DiningTableDao diningTableDao = new DiningTableDao();

    public List<DiningTable> list() {
        return diningTableDao.queryMulti("select * from diningTable", DiningTable.class);
    }

    public DiningTable getDiningTableById(int id) {
        return diningTableDao.querySingle("select * from diningTable where id=?", DiningTable.class, id);
    }

    public boolean orderDiningTable(int id, String orderName, String orderTel) {
        int update =
                diningTableDao.update("update diningTable set state='已经预定', orderName=?, orderTel=? where id=?",
                        orderName, orderTel, id);
        return update > 0;
    }

    // 更新餐桌就餐状态
    public boolean updateDiningTableState(int id, String state) {
        int update = diningTableDao.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }

    //提供方法，将指定的餐桌设置为空闲状态(订餐人置空, 电话置空)
    public boolean updateDiningTableToFree(int id, String state) {
        int update = diningTableDao.update("update diningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }
}
