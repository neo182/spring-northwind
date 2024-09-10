package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.Shipper;
import org.springframework.stereotype.Repository;

@Repository
public class ShipperDao extends AbstractHibernateDao<Shipper> {

	public ShipperDao() {
		setClazz(Shipper.class);
	}

}
