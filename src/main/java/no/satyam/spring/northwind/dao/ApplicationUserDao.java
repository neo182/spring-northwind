package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserDao extends AbstractHibernateDao<ApplicationUser> {

	public ApplicationUserDao() {
		setClazz(ApplicationUser.class);
	}

}
