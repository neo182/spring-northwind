package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.ApplicationUser;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.BeforeEach;
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
public class ApplicationUserDaoTest {

	@Autowired
	private ApplicationUserDao applicationUserDao;

	@Autowired
	private TestDataProvider dataProvider;

	private ApplicationUser applicationUser;

	@BeforeEach
	public void setUp() {
		applicationUser = dataProvider.getApplicationUser();
	}

	@Test
	public void shouldDoCRUDOperationsWithApplicationUser() {
		// Create
		ApplicationUser persistedUser = applicationUserDao.create(applicationUser);
		assertThat(persistedUser.getId(), is(notNullValue()));

		// Read
		ApplicationUser userById = applicationUserDao.findOne(persistedUser.getId());
		assertThat(userById, is(notNullValue()));
		assertThat(userById.getUserName(), equalTo(applicationUser.getUserName()));
		assertThat(userById.getPassword(), equalTo(applicationUser.getPassword()));

		// Update
		userById.setUserName("NewUserName");
		userById.setPassword("NewPass");
		ApplicationUser updatedUser = applicationUserDao.update(userById);
		assertThat(updatedUser.getUserName(), equalTo("NewUserName"));
		assertThat(updatedUser.getPassword(), equalTo("NewPass"));

		// Delete
		applicationUserDao.deleteById(userById.getId());
		ApplicationUser deletedUser = applicationUserDao.findOne(userById.getId());
		assertThat(deletedUser, is(nullValue()));
	}

}