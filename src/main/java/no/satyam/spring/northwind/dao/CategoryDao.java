package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractHibernateDao<Category> {

	public CategoryDao() {
		setClazz(Category.class);
	}

}
