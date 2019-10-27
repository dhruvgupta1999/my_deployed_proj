package log.springmvc.dao;

import java.util.List;

import log.springmvc.model.Accounts;
import log.springmvc.model.Customer;

public interface CustomerDao {
    void registerCustomer(Customer customer);
    public List<Customer> getallcustomers();
    Customer getcustomerdetails(String user);
    void updatecustomerdetails(Customer cust,String user);
}
