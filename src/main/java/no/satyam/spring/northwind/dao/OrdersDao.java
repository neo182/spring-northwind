package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.domain.OrderDetails;
import no.satyam.spring.northwind.domain.Orders;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao extends AbstractHibernateDao<Orders> {

	public OrdersDao() {
		setClazz(Orders.class);
	}

	public void addOrderDetails(Orders orders, OrderDetails... orderDetails) {
		if (orderDetails.length == 0) {
			return;
		}

		assert orders.getCustomer() != null;
		assert orders.getEmployee() != null;
		assert orders.getShipper() != null;

		for (OrderDetails details : orderDetails) {
			orders.addOrderDetails(details);
		}

		super.getCurrentSession().persist(orders);
	}

	public void removeOrderDetails(Orders orders, OrderDetails... orderDetails) {
		if (orderDetails.length == 0) {
			return;
		}

		assert orders.getCustomer() != null;
		assert orders.getEmployee() != null;
		assert orders.getShipper() != null;

		for (OrderDetails details : orderDetails) {
			orders.removeOrderDetails(details);
		}

		super.getCurrentSession().persist(orders);
	}


}
