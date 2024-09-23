package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.domain.Supplier;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Transactional
@ContextConfiguration(classes = { HibernateConfig.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class SupplierDaoTest {

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldAssociateProductsToASupplier() {
		Supplier supplier = dataProvider.getSupplier();
		Product product1 = dataProvider.getProduct();

		// Add product1 in a new supplier
		supplierDao.associateProductsWithSupplier(supplier, product1);

		Supplier supplierWithOneProduct = supplierDao.findOne(supplier.getId());
		List<Product> products = supplierWithOneProduct.getProducts();
		assertThat(products.size(), is(1));

		// Add product2 in an existing supplier
		Product product2 = dataProvider.getProduct();
		supplierDao.associateProductsWithSupplier(supplier, product2);
		Supplier suppplierWithTwoProducts = supplierDao.findOne(supplier.getId());
		products = suppplierWithTwoProducts.getProducts();
		assertThat(products.size(), is(2));
	}

	@Test
	public void shouldDissociateProductsFromASupplier() {
		Supplier supplier = dataProvider.getSupplier();
		Product product = dataProvider.getProduct();

		// Add a new product in a new supplier
		supplierDao.associateProductsWithSupplier(supplier, product);

		// Remove the product from the supplier
		supplierDao.dissociateProductsFromSupplier(supplier, product);

		Supplier supplierWithOneProduct = supplierDao.findOne(supplier.getId());
		List<Product> products = supplierWithOneProduct.getProducts();
		assertThat(products.size(), is(0));
	}

}