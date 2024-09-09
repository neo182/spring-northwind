package no.satyam.spring.northwind.testutil;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import no.satyam.spring.northwind.domain.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

@Component
public class TestDataProvider {

	private Faker faker = new Faker(new Locale("nb-NO"));

	private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nb-NO"), new RandomService());

	public ApplicationUser getApplicationUser() {
		ApplicationUser user = new ApplicationUser();
		user.setUserName(faker.name().username());
		user.setPassword(fakeValuesService.regexify("[a-z1-9]{10}"));
		return user;
	}

	public Category getCategory() {
		Category category = new Category();
		category.setName(faker.commerce().department());
		category.setDescription(faker.chuckNorris().fact());
		return category;
	}

	public Product getProduct() {
		Product product = new Product();
		product.setProductName(faker.commerce().productName());
		product.setDiscontinued(false);
		product.setReoderLevel(1);
		product.setQuantityPerUnit("1");
		product.setUnitPrice(BigDecimal.valueOf(199));
		product.setUnitsInStock(new Random().nextInt(10, 100));
		product.setUnitsInOrder(new Random().nextInt(10, 100));
		return product;
	}

	public Shipper getShipper() {
		Shipper shipper = new Shipper();
		shipper.setCompanyName(faker.company().name());
		shipper.setPhone(faker.phoneNumber().phoneNumber());
		return shipper;
	}

	public Supplier getSupplier() {
		Supplier supplier = new Supplier();
		supplier.setCompanyName(faker.company().name());
		supplier.setContactName(faker.name().fullName());
		supplier.setContactTitle(faker.name().title());
		supplier.setAddress(faker.address().fullAddress());
		supplier.setCity(faker.address().city());
		supplier.setRegion(faker.address().city());
		supplier.setPostalCode(faker.address().zipCode());
		supplier.setCountry(faker.address().country());
		supplier.setPhone(faker.phoneNumber().phoneNumber());
		supplier.setFax(faker.regexify("\\+[0-9]{1,3}-[0-9]{3}\\\\-[0-9]{7}"));
		supplier.setHomepage("http://www." + faker.lorem().characters(25, 50) + ".com");
		return supplier;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCompanyName(faker.company().name());
		customer.setContactTitle(faker.name().title());
		customer.setAddress(faker.address().streetAddress());
		customer.setCity(faker.address().city());
		customer.setRegion(faker.address().city());
		customer.setPostalCode(faker.address().zipCode());
		customer.setCountry(faker.address().country());
		customer.setPhone(faker.phoneNumber().phoneNumber());
		customer.setFax(fakeValuesService.regexify("[1-9]{10}"));
		return customer;
	}

	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(faker.name().firstName());
		employee.setLastName(faker.name().lastName());
		employee.setTitle(faker.name().prefix());
		employee.setTitleOfCourtesy(faker.name().suffix());
		employee.setBirthDate(Date.valueOf(LocalDate.of(1990, 1, 1)));
		employee.setHireDate(Date.valueOf(LocalDate.of(2010, 1, 1)));
		employee.setAddress(faker.address().streetAddress());
		employee.setRegion(faker.address().city());
		employee.setPostalCode(faker.address().zipCode());
		employee.setCountry(faker.address().country());
		employee.setExtension(faker.country().countryCode2());
		employee.setHomePhone(faker.phoneNumber().cellPhone());
		employee.setNotes(faker.chuckNorris().fact());
		employee.setReportsTo(faker.name().fullName());
		return employee;
	}

	public SalesOrder getSalesOrder(Customer customer, Employee employee, Shipper shipper) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setOrderDate(Date.valueOf(LocalDate.of(2020, 1, 1)));
		salesOrder.setRequiredDate(Date.valueOf(LocalDate.of(2020, 1, 2)));
		salesOrder.setShippedDate(Date.valueOf(LocalDate.of(2020, 1, 3)));
		salesOrder.setFreight(BigDecimal.valueOf(new Random().nextDouble(1000, 2000)));
		salesOrder.setShipName(faker.gameOfThrones().character());
		salesOrder.setShipAddress(faker.address().fullAddress());
		salesOrder.setShipCity(faker.address().city());
		salesOrder.setShipRegion(faker.address().city());
		salesOrder.setShipPostalCode(faker.address().zipCode());
		salesOrder.setShipCountry(faker.address().country());
		salesOrder.setCustomer(customer);
		salesOrder.setEmployee(employee);
		salesOrder.setShipper(shipper);
		return salesOrder;
	}

}
