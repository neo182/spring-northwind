package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Employee;
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
class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private TestDataProvider dataProvider;

	@Test
	public void shouldDoCRUDOperationsWithEmployee() {
		Employee employee = dataProvider.getEmployee();
		// Create
		Employee persistedEmployee = employeeDao.create(employee);
		assertThat(persistedEmployee.getId(), is(notNullValue()));

		// Read
		Employee employeeById = employeeDao.findOne(persistedEmployee.getId());
		assertThat(employeeById, is(notNullValue()));
		assertThat(employeeById.getFirstName(), equalTo(employee.getFirstName()));

		// Update
		employeeById.setFirstName("JohnDoe");
		Employee updatedEmployee = employeeDao.update(employeeById);
		assertThat(updatedEmployee.getFirstName(), equalTo(employeeById.getFirstName()));

		// Delete
		employeeDao.deleteById(employeeById.getId());
		Employee deletedEmployee = employeeDao.findOne(employeeById.getId());
		assertThat(deletedEmployee, is(nullValue()));
	}

}