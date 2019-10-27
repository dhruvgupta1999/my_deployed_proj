package log.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Employee;

public class EmployeeDaoimpl implements EmployeeDao {
	 @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public List<Employee> showEmployee() {
	    String sql = "select * from Employee";
	    return jdbcTemplate.query(sql, new EmployeeMapper());
       }
	  
	  public void updateempsalary(String username, int salary) {
		  String sql = "update Employee set Salary = " + salary +" where Username='"+ username +"'";
	      jdbcTemplate.update(sql);
	  }
	  
	  public void addemp(Employee emp) {
		  String sql = "insert into Employee value(?,?,?,?,?,?)";
		  jdbcTemplate.update(sql, new Object[] {emp.getUsername(),emp.getName(),emp.getSalary(),emp.getPassword(),emp.getAddress(),emp.getPhone()});
	  }
	  
}

