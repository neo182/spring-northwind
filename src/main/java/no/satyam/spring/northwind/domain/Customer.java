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
public class Customer extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String companyName;

	@Column(nullable = false)
	private String contactName;

	private String contactTitle;

	private String address;

	private String city;

	private String region;

	private String postalCode;

	private String country;

	private String phone;

	private String fax;

	// Orders is the owning side
	@OneToMany(mappedBy = "customer")
	private List<Orders> ordersList = new ArrayList<>();

	public Customer(String companyName, String contactName, String contactTitle, String address, String city,
			String region, String postalCode, String country, String phone, String fax) {
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
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(companyName, customer.companyName) && Objects.equals(contactName, customer.contactName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), companyName, contactName);
	}

}