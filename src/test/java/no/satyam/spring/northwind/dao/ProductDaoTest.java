package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateUnitTestConfig;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringJUnitConfig(classes = { HibernateUnitTestConfig.class })
public class ProductDaoTest {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldDoCRUDOperationsWithProduct() {
		Product product = dataProvider.getProduct();

		// Create
		Product persistedProduct = productDao.create(product);
		assertThat(persistedProduct.getId(), is(notNullValue()));

		// Read
		Product productById = productDao.findOne(persistedProduct.getId());
		assertThat(productById, is(notNullValue()));
		assertThat(productById.getProductName(), equalTo(product.getProductName()));

		// Update
		productById.setProductName("NewProductName");
		Product updatedProduct = productDao.update(productById);
		assertThat(updatedProduct.getProductName(), equalTo(productById.getProductName()));

		// Delete
		productDao.deleteById(productById.getId());
		Product deletedProduct = productDao.findOne(productById.getId());
		assertThat(deletedProduct, is(nullValue()));
	}

	@Test
	public void shouldFindProductsWithProperty() {
		Product product1 = dataProvider.getProduct();
		Product product2 = dataProvider.getProduct();

		product1.setProductName("ProductA");
		product2.setProductName("ProductB");
		productDao.create(product1);
		productDao.create(product2);

		assertThat(productDao.findByProperty("productName", "ProductA").size(), is(1));
		assertThat(productDao.findByProperty("productName", "ProductB").size(), is(1));
	}

}