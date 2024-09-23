package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Transactional
@ContextConfiguration(classes = { HibernateConfig.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class ProductDaoTest {

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

}