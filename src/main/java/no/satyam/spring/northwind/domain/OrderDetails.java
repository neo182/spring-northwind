package no.satyam.spring.northwind.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;

/**
 * @author srt
 */
@Entity
public class OrderDetails extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	private BigDecimal unitPrice;

	private Integer quantity;

	private BigDecimal discount;

	@ManyToOne(optional = false)
	@JoinColumn(name = "orders_id", foreignKey = @ForeignKey(name = "ORDERS_ID_FK"))
	private Orders orders;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PRODUCT_ID_FK"))
	private Product product;

	public OrderDetails() {
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}