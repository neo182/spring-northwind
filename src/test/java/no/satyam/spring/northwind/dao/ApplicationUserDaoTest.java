package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.ApplicationUser;
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

	private ApplicationUser applicationUser;

	@BeforeEach
	public void setUp() {
		applicationUser = new ApplicationUser();
		applicationUser.setUserName("sa");
		applicationUser.setPassword("sa");
	}

	@Test
	public void shouldCreateAapplicationUser() {
		ApplicationUser persistedApplicationUser = applicationUserDao.create(applicationUser);
		assertApplicationUser(persistedApplicationUser);
	}

	@Test
	public void shouldReadAPersistedApplicationUser() throws Exception {
		ApplicationUser persistedApplicationUser = applicationUserDao.create(applicationUser);
		ApplicationUser applicationUserById = applicationUserDao.findOne(persistedApplicationUser.getId());
		assertApplicationUser(applicationUserById);
	}

	private void assertApplicationUser(ApplicationUser persistedApplicationUser) {
		assertThat(persistedApplicationUser, is(notNullValue()));
		assertThat(persistedApplicationUser.getId(), is(not(equalTo(null))));
		assertThat(persistedApplicationUser.getUserName(), equalTo(applicationUser.getUserName()));
		assertThat(persistedApplicationUser.getPassword(), equalTo(applicationUser.getPassword()));
	}

}