package log.springmvc.dao;

import log.springmvc.model.Accounts;
import log.springmvc.model.Customer;
import log.springmvc.model.Employee;
//import log.springmvc.model
public interface AccountDao {
    void registerAcc(Accounts account);
    String validateCustomer(String user);
    String validateEmployee(String user);
    public String getUserRole(String user);
}
