package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import no.satyam.spring.northwind.util.ToStringGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author srt
 */
@Entity
public class Employee extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	private String title;

	private String titleOfCourtesy;

	private Date birthDate;

	private Date hireDate;

	private String address;

	private String city;

	private String region;

	private String postalCode;

	private String country;

	private String homePhone;

	private String extension;

	private String notes;

	private String reportsTo;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<SalesOrder> salesOrders = new ArrayList<>();

	public Employee() {
	}

	public Employee(String firstName, String lastName, String title, String titleOfCourtesy, Date birthDate,
			Date hireDate, String address, String city, String region, String postalCode, String country,
			String homePhone, String extension, String notes, String reportsTo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.homePhone = homePhone;
		this.extension = extension;
		this.notes = notes;
		this.reportsTo = reportsTo;
	}

	@Override
	public void setId(Long id) {
		super.setId(id); // To change body of generated methods, choose Tools | Templates.
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
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
		Employee employee = (Employee) o;
		return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName)
				&& Objects.equals(birthDate, employee.birthDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), firstName, lastName, birthDate);
	}

	@Override
	public String toString() {
		return ToStringGenerator.generateInMultiLine(this);
	}

}