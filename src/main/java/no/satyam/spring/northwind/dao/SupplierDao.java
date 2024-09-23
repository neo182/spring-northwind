package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.domain.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDao extends AbstractHibernateDao<Supplier> {

	public SupplierDao() {
		setClazz(Supplier.class);
	}

	public void associateProductsWithSupplier(Supplier supplier, Product... products) {
		if (products.length == 0) {
			return;
		}

		for (Product product : products) {
			supplier.associateProduct(product);
		}

		super.getCurrentSession().persist(supplier);
	}

	public void dissociateProductsFromSupplier(Supplier supplier, Product... products) {
		if (products.length == 0) {
			return;
		}

		for (Product product : products) {
			supplier.dissociateProduct(product);
		}

		super.getCurrentSession().persist(supplier);
	}

}
