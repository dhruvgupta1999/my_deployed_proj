package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Customer;

public class CustomerDaoimpl implements CustomerDao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public void registerCustomer(Customer user) {
	    String sql = "insert into Customer(Username,Password,Address,Email,Name,Phone) values(?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getAddress(),
	     user.getEmail(), user.getName(), user.getPhone() });
	    }
	  
	  public List<Customer> getallcustomers()
	  {
		  String sql = "select * from Customer";
		  return jdbcTemplate.query(sql, new CustomerMapper());
	  }
	  
	  public Customer getcustomerdetails(String user)
	  {
		  String sql = "select * from Customer where Username='"+user+"'";
		  return jdbcTemplate.query(sql, new CustomerMapper()).get(0);
	  }
	  
	  public void updatecustomerdetails(Customer cust,String user)
	  {
		  System.out.println("reached update customer details dao fn");
		  String sql  = "update Customer set Address='"+ cust.getAddress() + "', Email='" + cust.getEmail()
		  + "', Password='" + cust.getPassword() + "', Phone='" + cust.getPhone() +"', Name='" + cust.getName() + "' where Username='" + user + "'";
	     jdbcTemplate.update(sql);
	  }
}
