package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Customer;

/**
 *
 * @author srt
 */
public interface CustomerService {
    public List<Customer> getAllCustomers();
    
    public Customer saveCustomer(Customer customer);
    
    public void deleteCustomer(Customer customer);
    
    List<Customer> findByCompanyName(String companyName);

    List<Customer> findByContactName(String contactName);

    List<Customer> findByContactTitle(String contactTitle);

    List<Customer> findByCountry(String country);
}
