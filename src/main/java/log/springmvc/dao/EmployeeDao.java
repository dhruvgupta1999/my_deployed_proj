package log.springmvc.dao;

import log.springmvc.model.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> showEmployee();
    void updateempsalary(String username, int salary);
    public void addemp(Employee emp);
}
