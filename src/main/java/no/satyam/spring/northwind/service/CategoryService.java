package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Category;

/**
 *
 * @author srt
 */
public interface CategoryService {

    public List<Category> getAllCategories();

    public Category saveCategory(Category category);

    public void deleteCategory(Category category);

    public Category findByName(String name);
    
}
