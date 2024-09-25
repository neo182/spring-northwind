package no.satyam.spring.northwind.domain;

import jakarta.persistence.*;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author srt
 */
@Entity
public class Product extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String productName;

	private String quantityPerUnit;

	private BigDecimal unitPrice;

	private Integer unitsInStock;

	private Integer unitsInOrder;

	private Integer reoderLevel;

	private Boolean discontinued;

	@ManyToOne(optional = true)
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "CATEGORY_ID_FK"))
	private Category category;

	@ManyToOne(optional = true)
	@JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "SUPPLIER_ID_FK"))
	private Supplier supplier;

	@OneToMany(mappedBy = "product")
	private List<OrderDetails> orderDetails;

	public Product() {
	}

	@Override
	public void setId(Long id) {
		super.setId(id); // To change body of generated methods, choose Tools | Templates.
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Integer getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(Integer unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public Integer getReoderLevel() {
		return reoderLevel;
	}

	public void setReoderLevel(Integer reoderLevel) {
		this.reoderLevel = reoderLevel;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Product product = (Product) o;
		return Objects.equals(productName, product.productName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), productName);
	}

}
