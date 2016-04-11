package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.domain.Supplier;
import no.satyam.spring.northwind.repository.ProductRepository;
import no.satyam.spring.northwind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }

    @Override
    public Product findByProductName(String productName) {
        return repository.findByProductName(productName);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Product> findBySupplier(Supplier supplier) {
        return repository.findBySupplier(supplier);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
    
}
