package log.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Product;
import log.springmvc.model.Stringholder;
import log.springmvc.model.Supplier;

public class SupplierDaoimpl implements SupplierDao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
    public List<Supplier> getAllSupplierDetails()
    {
    	
    	String sql= " select * from Supplier";
    	return jdbcTemplate.query(sql,new SupplierMapper());
    }
    
    public List <String> getAllSupplierNames()
    {
    	String sql="select Company from Supplier";
    	return jdbcTemplate.query(sql,new Supplier_CompanyMapper());
    }
    
    public void addSupplier(Supplier supplier)
    {
    	String sql = "insert into Supplier values(?,?,?)";
    	jdbcTemplate.update(sql, new Object[] {supplier.getComp_id(),supplier.getCompany(),supplier.getLocation()});
    }
}


class SupplierMapper implements RowMapper<Supplier> {
    public Supplier mapRow(ResultSet rs, int arg1) throws SQLException {
    Supplier prod = new Supplier();
    prod.setComp_id(rs.getString("Comp_id"));
    prod.setCompany(rs.getString("Company"));
    prod.setLocation(rs.getString("Location"));
//    prod.setSize(rs.getString("Size"));
//    prod.setType(rs.getString("Type"));
    return prod;
  }
}


class Supplier_CompanyMapper implements RowMapper<String> {
    public String mapRow(ResultSet rs, int arg1) throws SQLException {
//    Stringholder prod = new Stringholder();
    	String mystring;
//    prod.setComp_id(rs.getString("Comp_id"));
       mystring = (rs.getString("Company"));
//    prod.setLocation(rs.getString("Location"));
//    prod.setSize(rs.getString("Size"));
//    prod.setType(rs.getString("Type"));
    return mystring;
  }
}
