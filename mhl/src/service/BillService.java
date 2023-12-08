package service;

import dao.BillDao;
import dao.MultiTableDao;
import domain.Bill;
import domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 17:19
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    private BillDao billDao = new BillDao();
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDao multiTableDao = new MultiTableDao();

    //编写点餐的方法
    //1. 生成账单
    //2. 需要更新对应餐桌的状态
    //3. 如果成功返回true, 否则返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号,UUID
        String billId = UUID.randomUUID().toString();
        // 计算并更新该 billId 的账单金额
        int update = billDao.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    // 返回所有的账单， 提供给View调用
    public List<Bill> list() {
        return billDao.queryMulti("select * from bill", Bill.class);
    }

    //返回所有的账单并带有菜品名,价格， 提供给View调用
    public List<MultiTableBean> list2() {
        return multiTableDao.queryMulti("SELECT bill.*, NAME, price " +
                "FROM bill, menu " +
                "WHERE bill.menuId = menu.id", MultiTableBean.class);
    }

    // 查看某个餐桌 diningTableId 是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill =
                billDao.querySingle("SELECT * FROM bill WHERE diningTableId=? AND state = '未结账' LIMIT 0, 1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账[如果餐桌存在，并且该餐桌有未结账的账单]
    //如果成功，返回true, 失败返回 false
    public boolean payBill(int diningTableId, String payMode) {
        // 1. 修改 bill 表
        int update = billDao.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);
        if(update <= 0) { //如果更新没有成功，则表示失败...
            return false;
        }

        //2. 修改diningTable表
        if(!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }


}
