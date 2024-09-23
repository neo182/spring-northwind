package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Shipper;
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