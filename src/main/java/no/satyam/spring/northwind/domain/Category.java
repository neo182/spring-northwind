package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author srt
 */
@Entity
public class Category extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String name;

	private String description;

	// mappedBy indicating 'category' owns the relationship.
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<>();

	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}