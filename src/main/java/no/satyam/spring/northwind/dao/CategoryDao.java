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
		for (Product product : products) {
			category.getProducts().add(product);
		}

		sessionFactory.getCurrentSession().persist(category);
	}

}
