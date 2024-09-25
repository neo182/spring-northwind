package no.satyam.spring.northwind.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;

/**
 * @author srt
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
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

}