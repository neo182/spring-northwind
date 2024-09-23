package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Customer;
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
class CustomerDaoTest {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldDoCRUDOperationsWithCustomer() {
		Customer customer = dataProvider.getCustomer();
		// Create
		Customer persistedCustomer = customerDao.create(customer);
		assertThat(persistedCustomer.getId(), is(notNullValue()));

		// Read
		Customer customerById = customerDao.findOne(persistedCustomer.getId());
		assertThat(customerById, is(notNullValue()));
		assertThat(customerById.getCompanyName(), equalTo(customer.getCompanyName()));

		// Update
		customerById.setCompanyName("Zion & Co.");
		customerById.setCountry("Norway");
		Customer updatedCustomer = customerDao.update(customerById);
		assertThat(updatedCustomer.getCompanyName(), equalTo(customerById.getCompanyName()));
		assertThat(updatedCustomer.getCountry(), equalTo(customerById.getCountry()));

		// Delete
		customerDao.deleteById(customerById.getId());
		Customer deletedCustomer = customerDao.findOne(customerById.getId());
		assertThat(deletedCustomer, is(nullValue()));
	}

}