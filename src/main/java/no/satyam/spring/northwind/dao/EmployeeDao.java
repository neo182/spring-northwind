package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee> {

	public EmployeeDao() {
		setClazz(Employee.class);
	}

}
