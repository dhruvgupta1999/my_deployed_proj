package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Accounts;
import log.springmvc.model.Customer;
import log.springmvc.model.Employee;

public class AccountDaoimpl implements AccountDao {
	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  
	  
	  public void registerAcc(Accounts account) {
		  
		  String sql = "insert into Accounts(Username,Password,UserRole) values(?,?,?)";
		  jdbcTemplate.update(sql, new Object[] { account.getUsername(), account.getPassword(),account.getUserRole() });
//		  String sql = "insert into User_Role values(?,?)";
		  
		  
	  }
	  
	  public String validateCustomer(String user) {
	  String sql = "select * from Accounts where Username='" + user + "'" ;
	    List<String> users = jdbcTemplate.query(sql, new AccountMapper());
	    return users.size() > 0 ? users.get(0) : null;
	  }
	  
	  public String validateEmployee(String user) {
		  String sql = "select * from Accounts where Username='" + user + "'";
		    List<String> users = jdbcTemplate.query(sql, new AccountMapper());
		    return users.size() > 0 ? users.get(0) : null;
		  }
	  
	  public String getUserRole(String user) {
		  String sql = "select UserRole from Accounts where Username = '"+ user + "'";
		  List<String> s =  jdbcTemplate.query(sql, new AccountMapper());
		  return s.size() > 0 ? s.get(0) : null;
	  }
	  
	  
}


// helps in validation
class CustomerMapper implements RowMapper<Customer> {
	    public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
	    Customer user = new Customer();
	    user.setUsername(rs.getString("Username"));
	    user.setPassword(rs.getString("Password"));
	    user.setAddress(rs.getString("Address"));
	    user.setName(rs.getString("Name"));
	    user.setPhone(rs.getString("Phone"));
	    user.setEmail(rs.getString("Email"));
	    return user;
	  }
}

class EmployeeMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
    Employee user = new Employee();
    user.setUsername(rs.getString("Username"));
    user.setPassword(rs.getString("Password"));
    user.setAddress(rs.getString("Address"));
    user.setSalary(rs.getString("Salary"));
    user.setPhone(rs.getString("Phone"));
    user.setName(rs.getString("Name"));
    return user;
  }
}

class AccountMapper implements RowMapper<String> {
    public String mapRow(ResultSet rs, int arg1) throws SQLException {
    String user_role;
    user_role = rs.getString("UserRole");
    return user_role;
  }
}







