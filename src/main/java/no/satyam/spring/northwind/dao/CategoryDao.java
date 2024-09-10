package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractHibernateDao<Category> {

	public CategoryDao() {
		setClazz(Category.class);
	}

	public void addProductsInCategory(Category category, Product... products) {
		if (products.length == 0) {
			return;
		}

		for (Product product : products) {
			category.addProduct(product);
		}

		super.getCurrentSession().persist(category);
	}

	public void removeProductsFromCategory(Category category, Product... products) {
		if (products.length == 0) {
			return;
		}

		for (Product product : products) {
			category.removeProduct(product);
		}

		super.getCurrentSession().persist(category);
	}

}
