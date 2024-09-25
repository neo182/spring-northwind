package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateUnitTestConfig;
import no.satyam.spring.northwind.domain.Shipper;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringJUnitConfig(classes = { HibernateUnitTestConfig.class })
class ShipperDaoTest {

	@Autowired
	private ShipperDao shipperDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldDoCRUDOperationsWithShipper() {
		Shipper shipper = dataProvider.getShipper();
		// Create
		Shipper persistedShipper = shipperDao.create(shipper);
		assertThat(persistedShipper.getId(), is(notNullValue()));

		// Read
		Shipper shipperById = shipperDao.findOne(persistedShipper.getId());
		assertThat(shipperById, is(notNullValue()));
		assertThat(shipperById.getCompanyName(), equalTo(shipper.getCompanyName()));

		// Update
		shipperById.setCompanyName("Zion Co.");
		Shipper updatedShipper = shipperDao.update(shipperById);
		assertThat(updatedShipper.getCompanyName(), equalTo(shipperById.getCompanyName()));

		// Delete
		shipperDao.deleteById(shipperById.getId());
		Shipper deletedShipper = shipperDao.findOne(shipperById.getId());
		assertThat(deletedShipper, is(nullValue()));
	}

}