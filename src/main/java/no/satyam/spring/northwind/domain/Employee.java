package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.sql.Date;
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
	private List<Orders> ordersList = new ArrayList<>();

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

}