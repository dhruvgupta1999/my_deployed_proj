package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//import log.springmvc.model.Cart;
import log.springmvc.model.Customer;
import log.springmvc.model.Cart;
import log.springmvc.model.Cartdisplay;
//import log.springmvc.model.Cart;

public class CartDaoimpl implements CartDao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public List<Cartdisplay> showCart(String user) {
		  System.out.println("reached showCart()");
	    String sql = "select * from Cart,Product where Username='" + user + "' and Cart.P_id = Product.P_id";
	    return jdbcTemplate.query(sql, new CartdisplayMapper());
     }
	  
	 public void addtoCart(Cart  cart)
	 {
		 String sql = "insert into Cart(Username,P_id,Qty) values(?,?,?)";
		  jdbcTemplate.update(sql, new Object[] { cart.getUsername(), cart.getP_id(),cart.getQty() });
	 }
	 public void removefromCart(String username, int C_id) {
		String sql = "delete from Cart where Username=? and C_id=?";
		jdbcTemplate.update(sql, new Object[] { username, C_id });
	 }
}

class CartdisplayMapper implements RowMapper<Cartdisplay> {
    public Cartdisplay mapRow(ResultSet rs, int arg1) throws SQLException {
    Cartdisplay cart = new Cartdisplay();
    cart.setC_id(rs.getInt("C_id"));
    cart.setUsername(rs.getString("Username"));
    cart.setP_id(rs.getString("P_id"));
    cart.setCompany(rs.getString("Company"));
    cart.setPrice(rs.getDouble("Price"));
    cart.setType(rs.getString("Type"));
    cart.setSize(rs.getString("Size"));
    cart.setTprice(Math.round(rs.getDouble("Price")*rs.getInt("Qty")*100)/100.0);
    cart.setQty(rs.getInt("Qty"));
    System.out.println(cart.getType());
    return cart;
  }
}

class CartMapper implements RowMapper<Cart> {
    public Cart mapRow(ResultSet rs, int arg1) throws SQLException {
    Cart cart = new Cart();
    cart.setUsername(rs.getString("Username"));
    cart.setP_id(rs.getString("P_id"));
    cart.setC_id(rs.getInt("C_id"));
    cart.setQty(rs.getInt("Qty"));
    
    return cart;
  }
} 
