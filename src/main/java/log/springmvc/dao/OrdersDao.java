package log.springmvc.dao;

import java.util.List;

//import log.springmvc.model.Cart;
import log.springmvc.model.Customer;
import log.springmvc.model.Orderdisplay;
import log.springmvc.model.Orders;
import log.springmvc.model.PendingOrderdisplay;

public interface OrdersDao {
    List<Orderdisplay> showOrders(String user);
    public void addCarttoOrders(String user);
    public void setOrderstatustocompleted(int ord_id);
    public List<PendingOrderdisplay> showPendingOrders();
}
