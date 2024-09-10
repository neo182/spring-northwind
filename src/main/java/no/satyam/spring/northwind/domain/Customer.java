package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	// SalesOrder is the owning side
	@OneToMany(mappedBy = "customer")
	private List<SalesOrder> salesOrders = new ArrayList<>();

	public Customer() {
	}

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
		super.setId(id); // To change body of generated methods, choose Tools | Templates.
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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
		Customer customer = (Customer) o;
		return Objects.equals(companyName, customer.companyName) && Objects.equals(contactName, customer.contactName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), companyName, contactName);
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}