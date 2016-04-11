package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Category;
import no.satyam.spring.northwind.domain.Product;
import no.satyam.spring.northwind.domain.Supplier;

/**
 *
 * @author srt
 */
public interface ProductService {

    public List<Product> getAllProducts();

    public Product saveProduct(Product product);

    public void deleteProduct(Product product);

    public Product findByProductName(String productName);

    public List<Product> findByCategory(Category category);

    public List<Product> findBySupplier(Supplier supplier);
}
