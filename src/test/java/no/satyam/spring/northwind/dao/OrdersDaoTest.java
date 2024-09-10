package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.*;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Transactional
@ContextConfiguration(classes = { HibernateConfig.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class OrdersDaoTest {

	@Autowired
	private OrdersDao ordersDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private ShipperDao shipperDao;

	@Test
	public void shouldCreateAndSaveAnOrder() {
		// create dummy orders object
		Product product = productDao.create(dataProvider.getProduct());
		Employee employee = employeeDao.create(dataProvider.getEmployee());
		Customer customer = customerDao.create(dataProvider.getCustomer());
		Shipper shipper = shipperDao.create(dataProvider.getShipper());

		// Bootstrapping product and orderdetails
		OrderDetails details = dataProvider.getOrderDetails(product);
		Orders orders = dataProvider.getOrders(customer, employee, shipper);
		ordersDao.addOrderDetails(orders, details);

		assertThat(orders.getId(), is(1L));
	}

}