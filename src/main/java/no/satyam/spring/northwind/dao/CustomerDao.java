package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends AbstractHibernateDao<Customer> {

	public CustomerDao() {
		setClazz(Customer.class);
	}

}
