package no.satyam.spring.northwind.config;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Properties;

@Configuration
@Import(HibernateConfig.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class HibernateUnitTestConfig {

	@Autowired
	private Properties properties;

	@PostConstruct
	public void initialize() {
		properties.put("spring.datasource.url", "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
		properties.put("spring.datasource.driver-class-name", "org.h2.Driver");
		properties.put("spring.datasource.username", "sa");
		properties.put("spring.datasource.username", "");
	}

}
