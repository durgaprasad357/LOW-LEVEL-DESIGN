/*
 *  Proxy Design Pattern:
 *      - This pattern helps to provide control access to original object.
 *  Exp:
 *      - The proxy acts like a middle layer, between the client and resource.
 * 
 *      client -------------> Proxy -------------> resource
 *      client <------------- Proxy <------------- resource
 */

import helperInterfaces.EmployeeDao;

class EmployeeDaoImpl implements EmployeeDao {
    public void create(int user_id) {
        System.out.println("Row Created.");
    }
}

class EmployeeDaoProxy implements EmployeeDao {
    EmployeeDao employeeDao;

    EmployeeDaoProxy() {
        employeeDao = new EmployeeDaoImpl();
    }

    public void create(int user_id) {
        if (user_id == -1) // if admin.
            employeeDao.create(user_id);
        else
            throw new AssertionError("User not allowed to create a row.");
    }
}

public class ProxyDesignPattern {
    public static void main(String[] args) {
        int user_id = -1;
        EmployeeDaoProxy employeeDaoProxy = new EmployeeDaoProxy();
        employeeDaoProxy.create(user_id);
    }
}
