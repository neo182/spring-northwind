package no.satyam.spring.northwind.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * @author srt
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ApplicationUser extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Column(unique = true)
	private String userName;

	private String password;

}
