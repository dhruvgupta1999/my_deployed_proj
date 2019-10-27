package log.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Color_combinations;
import log.springmvc.model.Product;
import log.springmvc.model.Stringholder;
import java.sql.ResultSet;


public class Colordaoimpl implements Colordao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	public String getceilcolor(String wallcolor)
	{
	    String sql= "select Ceil_color from Color_combinations where Wall_color='" + wallcolor + "'";
	    List<String> ls = jdbcTemplate.query(sql, new ColorMapper());
	    return ls.size()>0 ? ls.get(0) : null;
	    
	}
}

class ColorMapper implements RowMapper<String> {
    public String mapRow(ResultSet rs, int arg1) throws SQLException {
    String user_role;
    user_role = rs.getString("Ceil_color");
    return user_role;
  }
}

