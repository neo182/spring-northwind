package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
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
public class Supplier extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String companyName;

	private String contactName;

	private String contactTitle;

	private String address;

	private String city;

	private String region;

	private String postalCode;

	private String country;

	private String phone;

	private String fax;

	private String homepage;

	@OneToMany(mappedBy = "supplier")
	private List<Product> products = new ArrayList<>();

	public Supplier(String companyName, String contactName, String contactTitle, String address, String city,
			String region, String postalCode, String country, String phone, String fax, String homepage) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
		this.homepage = homepage;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public void associateProduct(Product product) {
		products.add(product);
		product.setSupplier(this);
	}

	public void dissociateProduct(Product product) {
		products.remove(product);
		product.setSupplier(null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Supplier supplier = (Supplier) o;
		return Objects.equals(companyName, supplier.companyName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), companyName);
	}

}