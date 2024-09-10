package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractHibernateDao<Product> {

	public ProductDao() {
		setClazz(Product.class);
	}

}
