package no.satyam.spring.northwind.domain;

import jakarta.persistence.*;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author srt
 */
@Entity
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
	private List<OrderDetails> orderDetailsList;

	public Orders() {
	}

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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public List<OrderDetails> getSalesOrderDetailsList() {
		return orderDetailsList;
	}

	public void setSalesOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}