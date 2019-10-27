package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Employee;
import log.springmvc.model.Product;

public class ProductDaoimpl implements ProductDao {
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	public void addProduct(Product product) {
		String sql = "insert into Product values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { product.getP_id(), product.getType() ,product.getSize() ,product.getCompany() ,product.getPrice() });
	}
	
    public Product getProd(String Type, String Size, String Company) {
    	// TODO Auto-generated method stub
    	String sql = "select * from Product where Type=? and Size=? and Company=?";
    	List<Product> pl =  jdbcTemplate.query(sql, new Object[] {Type, Size , Company}, new ProductMapper());
    	return pl.size()>0 ? pl.get(0) : null; 
    }

}

class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    Product prod = new Product();
    prod.setP_id(rs.getString("P_id"));
    prod.setCompany(rs.getString("Company"));
    prod.setPrice(rs.getDouble("Price"));
    prod.setSize(rs.getString("Size"));
    prod.setType(rs.getString("Type"));
    return prod;
  }
}
