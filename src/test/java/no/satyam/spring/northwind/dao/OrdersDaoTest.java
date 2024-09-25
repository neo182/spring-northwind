package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateUnitTestConfig;
import no.satyam.spring.northwind.domain.*;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringJUnitConfig(classes = { HibernateUnitTestConfig.class })
@Transactional
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
		// Bootstrapping product, employee, customer and shipper
		Product product = productDao.create(dataProvider.getProduct());
		Employee employee = employeeDao.create(dataProvider.getEmployee());
		Customer customer = customerDao.create(dataProvider.getCustomer());
		Shipper shipper = shipperDao.create(dataProvider.getShipper());

		// Creating two orderDetails
		OrderDetails details1 = dataProvider.getOrderDetails(product);
		OrderDetails details2 = dataProvider.getOrderDetails(product);

		Orders orders = dataProvider.getOrders(customer, employee, shipper);
		ordersDao.addOrderDetails(orders, details1, details2);

		assertThat(orders.getId(), is(1L));
		assertThat(orders.getOrderDetailsList().size(), is(2));
	}

	@Test
	public void shouldDeleteAnExistingAnOrderDetails() {
		// Bootstrapping product, employee, customer and shipper
		Product product = productDao.create(dataProvider.getProduct());
		Employee employee = employeeDao.create(dataProvider.getEmployee());
		Customer customer = customerDao.create(dataProvider.getCustomer());
		Shipper shipper = shipperDao.create(dataProvider.getShipper());

		// Creating two orderDetails
		OrderDetails details1 = dataProvider.getOrderDetails(product);
		OrderDetails details2 = dataProvider.getOrderDetails(product);

		Orders orders = dataProvider.getOrders(customer, employee, shipper);
		ordersDao.addOrderDetails(orders, details1, details2);

		// Removing first orderDetails
		ordersDao.removeOrderDetails(orders, details1);
		assertThat(orders.getOrderDetailsList().size(), is(1));
	}

}