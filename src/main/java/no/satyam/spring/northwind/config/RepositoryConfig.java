package no.satyam.spring.northwind.config;

import no.satyam.spring.northwind.domain.Category;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.lang.reflect.Array;
import java.util.UUID;

@Configuration
@EnableJdbcRepositories(basePackages = "no.satyam.spring.northwind.repository")
public class RepositoryConfig {

    @Bean
    public ApplicationListener<BeforeSaveEvent<Object>> idSetting() {
        return event -> {
            if (event.getEntity() instanceof Category) {
                Category category = (Category) event.getEntity();
                if (category.getId() == null) {
                    category.setId(UUID.randomUUID());
                }
            }

        };
    }
}
