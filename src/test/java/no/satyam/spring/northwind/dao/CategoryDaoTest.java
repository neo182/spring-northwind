package no.satyam.spring.northwind.dao;

import no.satyam.spring.northwind.config.HibernateConfig;
import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.testutil.TestDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Transactional
@ContextConfiguration(classes = { HibernateConfig.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private TestDataProvider dataProvider;

	private Category category;

	@BeforeEach
	public void setUp() {
		category = dataProvider.getCategory();
	}

	@Test
	public void shouldDoCRUDOperationsWithApplicationUser() {
		// Create
		Category persistedCategory = categoryDao.create(category);
		assertThat(persistedCategory.getId(), is(notNullValue()));

		// Read
		Category categoryById = categoryDao.findOne(persistedCategory.getId());
		assertThat(categoryById, is(notNullValue()));
		assertThat(categoryById.getName(), equalTo(category.getName()));
		assertThat(categoryById.getDescription(), equalTo(category.getDescription()));

		// Update
		categoryById.setName("NewName");
		categoryById.setDescription("NewDescription");
		Category updatedCategory = categoryDao.update(categoryById);
		assertThat(updatedCategory.getName(), equalTo(categoryById.getName()));
		assertThat(updatedCategory.getDescription(), equalTo(categoryById.getDescription()));

		// Delete
		categoryDao.deleteById(categoryById.getId());
		Category deletedCategory = categoryDao.findOne(categoryById.getId());
		assertThat(deletedCategory, is(nullValue()));
	}

}