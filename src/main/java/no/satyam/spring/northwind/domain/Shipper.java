package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author srt
 */
@Entity
public class Shipper extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String companyName;

	private String phone;

	@OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY)
	private List<SalesOrder> salesOrders = new ArrayList<>();

	public Shipper() {
	}

	public Shipper(String companyName, String phone) {
		this.companyName = companyName;
		this.phone = phone;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<SalesOrder> getSalesOrders() {
		return salesOrders;
	}

	public void setSalesOrders(List<SalesOrder> salesOrders) {
		this.salesOrders = salesOrders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Shipper shipper = (Shipper) o;
		return Objects.equals(companyName, shipper.companyName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), companyName);
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}