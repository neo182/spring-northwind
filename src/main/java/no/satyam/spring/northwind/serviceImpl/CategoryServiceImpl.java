package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.repository.CategoryRepository;
import no.satyam.spring.northwind.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository repository;

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        repository.delete(category);
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name);
    }

}
