package log.springmvc.dao;

import java.util.List;

import log.springmvc.model.Cart;
import log.springmvc.model.Cartdisplay;
import log.springmvc.model.Customer;

public interface CartDao {
    List<Cartdisplay> showCart(String user);
    void addtoCart(Cart cart);
    void removefromCart(String username, int C_id);
    
}
