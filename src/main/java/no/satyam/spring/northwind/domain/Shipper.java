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
public class Shipper extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String companyName;

	private String phone;

	@OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY)
	private List<Orders> ordersList = new ArrayList<>();

	public Shipper(String companyName, String phone) {
		this.companyName = companyName;
		this.phone = phone;
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
		Shipper shipper = (Shipper) o;
		return Objects.equals(companyName, shipper.companyName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), companyName);
	}

}