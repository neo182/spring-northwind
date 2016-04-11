package no.satyam.spring.northwind;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * As Spring 4.0 provides easy support for specifying seperate configuration for production and test setup, this one is
 * responsible for the production environment
 *
 * @author srt
 */
@Configuration
@EnableJpaRepositories("no.satyam.spring.northwind.repository")
@ComponentScan("no.satyam.spring")
@Import(InfrastructureConfigProd.class)
public class ApplicationConfigProd {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return DataSourceProvider.getMySqlDataSource();
    }
}
