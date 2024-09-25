package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateUnitTestConfig;
import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringJUnitConfig(classes = { HibernateUnitTestConfig.class })
@Transactional
class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldDoCRUDOperationsWithCategory() {
		Category category = dataProvider.getCategory();
		// Create
		Category persistedCategory = categoryDao.create(category);
		assertThat(persistedCategory.getId(), is(notNullValue()));

		// Read
		Category categoryById = categoryDao.findOne(persistedCategory.getId());
		assertThat(categoryById, is(notNullValue()));
		assertThat(categoryById.getName(), equalTo(category.getName()));
		assertThat(categoryById.getDescription(), equalTo(category.getDescription()));

		// Update
		categoryById.setName("NewName");
		categoryById.setDescription("NewDescription");
		Category updatedCategory = categoryDao.update(categoryById);
		assertThat(updatedCategory.getName(), equalTo(categoryById.getName()));
		assertThat(updatedCategory.getDescription(), equalTo(categoryById.getDescription()));

		// Delete
		categoryDao.deleteById(categoryById.getId());
		Category deletedCategory = categoryDao.findOne(categoryById.getId());
		assertThat(deletedCategory, is(nullValue()));
	}

	@Test
	public void shouldAddProductsInACategory() {
		Category category = dataProvider.getCategory();
		Product product1 = dataProvider.getProduct();

		// Add product1 in a new category
		categoryDao.addProductsInCategory(category, product1);

		Category categoryWithOneProduct = categoryDao.findOne(category.getId());
		List<Product> products = categoryWithOneProduct.getProducts();
		assertThat(products.size(), is(1));

		// Add product2 in an existing category
		Product product2 = dataProvider.getProduct();
		categoryDao.addProductsInCategory(category, product2);
		Category categoryWithTwoProducts = categoryDao.findOne(category.getId());
		products = categoryWithTwoProducts.getProducts();
		assertThat(products.size(), is(2));
	}

	@Test
	public void shouldDeleteExistingProductsFromACategory() {
		Category category = dataProvider.getCategory();
		Product product = dataProvider.getProduct();

		// Add a new product in a new category
		categoryDao.addProductsInCategory(category, product);

		// Remove the product from the category
		categoryDao.removeProductsFromCategory(category, product);

		Category categoryWithOneProduct = categoryDao.findOne(category.getId());
		List<Product> products = categoryWithOneProduct.getProducts();
		assertThat(products.size(), is(0));
	}

}