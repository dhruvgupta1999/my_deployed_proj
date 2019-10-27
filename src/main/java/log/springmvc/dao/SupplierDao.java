package log.springmvc.dao;

import java.util.List;

import log.springmvc.model.Supplier;

public interface SupplierDao {
	List<Supplier> getAllSupplierDetails();
	List <String> getAllSupplierNames();
	void addSupplier(Supplier supplier);
}
