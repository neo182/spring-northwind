package no.satyam.spring.northwind.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author srt
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String name;

	private String description;

	// mappedBy indicating 'Product' (the child side) owns the relationship.
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public void addProduct(Product product) {
		products.add(product);
		product.setCategory(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.setCategory(null);
	}

}