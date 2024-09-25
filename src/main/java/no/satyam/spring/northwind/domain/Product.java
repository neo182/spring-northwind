package no.satyam.spring.northwind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author srt
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
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

	@Override
	public void setId(Long id) {
		super.setId(id); // To change body of generated methods, choose Tools | Templates.
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
