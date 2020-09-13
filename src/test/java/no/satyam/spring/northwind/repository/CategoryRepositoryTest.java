package no.satyam.spring.northwind.repository;

import no.satyam.spring.northwind.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("inmemory")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testSaveCategory() {
        Category category = new Category("testCategory", "Test description");
        Category categorySaved = repository.save(category);

        Assertions.assertThat(categorySaved.getId()).isNotNull();
        Assertions.assertThat(categorySaved.getName()).isEqualTo("testCategory");
        Assertions.assertThat(categorySaved.getDescription()).isEqualTo("Test description");
    }
}
