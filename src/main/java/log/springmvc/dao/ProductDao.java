package log.springmvc.dao;


import log.springmvc.model.Product;

public interface ProductDao {
    void addProduct(Product product);
    Product getProd(String Type,String Size,String Company);
}
