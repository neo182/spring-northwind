package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Customer;
import no.satyam.spring.northwind.repository.CustomerRepository;
import no.satyam.spring.northwind.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public List<Customer> findByCompanyName(String companyName) {
        return repository.findByCompanyName(companyName);
    }

    @Override
    public List<Customer> findByContactName(String contactName) {
        return repository.findByContactName(contactName);
    }

    @Override
    public List<Customer> findByContactTitle(String contactTitle) {
        return repository.findByContactTitle(contactTitle);
    }

    @Override
    public List<Customer> findByCountry(String country) {
        return repository.findByCountry(country);
    }
    
}
