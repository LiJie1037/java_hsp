package service;

import dao.EmployeeDao;
import domain.Employee;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/8 14:58
 */
public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    public static boolean checkUser(String userId, String pwd) {
        return true;
    }

    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDao.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);
    }
}
