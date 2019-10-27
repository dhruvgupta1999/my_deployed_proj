package log.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import log.springmvc.model.Cart;
import log.springmvc.model.Cartdisplay;
//import log.springmvc.model.Cart;
import log.springmvc.model.Customer;
import log.springmvc.model.Orderdisplay;
import log.springmvc.model.Orders;
import log.springmvc.model.PendingOrderdisplay;
//import log.springmvc.model.Orders;

public class OrdersDaoimpl implements OrdersDao{
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public List<Orderdisplay> showOrders(String user) {
	    String sql = "select * from Orders,Product where Username='" + user + "' and Orders.P_id = Product.P_id";
	    return jdbcTemplate.query(sql, new OrdersMapper());
     }
	  
	  
	  public List<PendingOrderdisplay> showPendingOrders() {
		    String sql = "select * from Orders,Product,Customer where Status='" + "In process" + "' and Orders.P_id = Product.P_id and Orders.Username=Customer.Username";
		    return jdbcTemplate.query(sql, new PendingOrdersMapper());
	     }
	  
	  
	 public void addCarttoOrders(String user) // automatically removes from cart as well
	 {
		 String sql1 = "select * from Cart where Username='" + user + "'";
		 List<Cart> cart_items =  jdbcTemplate.query(sql1, new CartMapper());
		 String sql2 = "delete from Cart where Username='" + user + "'";
		 jdbcTemplate.update(sql2);
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");  
         String strDate = dateFormat.format(date);  
//         System.out.println("Converted String: " + strDate);  
		 for (Cart temp : cart_items) {
			 System.out.println("added an order");
			 String sql = "insert into Orders(Username,P_id,Qty,Date_ord,Status) values(?,?,?,?,?)";
			  jdbcTemplate.update(sql, new Object[] { temp.getUsername(), temp.getP_id(), temp.getQty() , strDate , "In process"});
			}	  
	 }
	 
	 public void setOrderstatustocompleted(int ord_id)
	 {
		 String sql ="update Orders set Status = '" + "Order Completed" +"' where O_id="+ ord_id ;
		 jdbcTemplate.update(sql);
	 }
}

class OrdersMapper implements RowMapper<Orderdisplay> {
    public Orderdisplay mapRow(ResultSet rs, int arg1) throws SQLException {
    Orderdisplay cart = new Orderdisplay();
    cart.setUsername(rs.getString("Username"));
    cart.setP_id(rs.getString("P_id"));
    cart.setCompany(rs.getString("Company"));
    cart.setPrice(rs.getDouble("Price"));
    cart.setType(rs.getString("Type"));
    cart.setSize(rs.getString("Size"));
    cart.setTprice(Math.round(rs.getDouble("Price")*rs.getInt("Qty")*100)/100.0);
    cart.setDate(rs.getString("Date_ord"));
    cart.setQty(rs.getInt("Qty"));
    cart.setStatus(rs.getString("Status"));
    cart.setO_id(rs.getInt("O_id"));
    return cart;
  }
}

class PendingOrdersMapper implements RowMapper<PendingOrderdisplay> {
    public PendingOrderdisplay mapRow(ResultSet rs, int arg1) throws SQLException {
    PendingOrderdisplay cart = new PendingOrderdisplay();
    cart.setUsername(rs.getString("Username"));
    cart.setP_id(rs.getString("P_id"));
    cart.setCompany(rs.getString("Company"));
    cart.setPrice(rs.getDouble("Price"));
    cart.setType(rs.getString("Type"));
    cart.setSize(rs.getString("Size"));
    cart.setTprice(Math.round(rs.getDouble("Price")*rs.getInt("Qty")*100)/100.0);
    cart.setDate(rs.getString("Date_ord"));
    cart.setQty(rs.getInt("Qty"));
    cart.setStatus(rs.getString("Status"));
    cart.setO_id(rs.getInt("O_id"));
    cart.setName(rs.getString("Name"));
    cart.setAddress(rs.getString("Address"));
    System.out.println(cart.getName());
    System.out.println(cart.getAddress());
    return cart;
  }
}
