package no.satyam.spring.northwind.domain;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author srt
 */
@Entity
public class SalesOrderDetails extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	private BigDecimal unitPrice;

	private Integer quantity;

	private BigDecimal discount;

	@ManyToOne(optional = false)
	@JoinColumn(name = "salesorder_id")
	private SalesOrder salesOrder;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	public SalesOrderDetails() {
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

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
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