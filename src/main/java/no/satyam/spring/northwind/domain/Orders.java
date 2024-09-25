package no.satyam.spring.northwind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author srt
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Orders extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	private Date orderDate;

	private Date requiredDate;

	private Date shippedDate;

	private BigDecimal freight;

	private String shipName;

	private String shipAddress;

	private String shipCity;

	private String shipRegion;

	private String shipPostalCode;

	private String shipCountry;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "CUSTOMER_ID_FK"))
	private Customer customer;

	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "EMPLOYEE_ID_FK"))
	private Employee employee;

	@ManyToOne(optional = false)
	@JoinColumn(name = "shipper_id", foreignKey = @ForeignKey(name = "SHIPPER_ID_FK"))
	private Shipper shipper;

	@OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<OrderDetails> orderDetailsList = new ArrayList<>();

	public void addOrderDetails(OrderDetails orderDetails) {
		orderDetailsList.add(orderDetails);
		orderDetails.setOrders(this);
	}

	public void removeOrderDetails(OrderDetails orderDetails) {
		orderDetailsList.remove(orderDetails);
		orderDetails.setOrders(null);
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

}