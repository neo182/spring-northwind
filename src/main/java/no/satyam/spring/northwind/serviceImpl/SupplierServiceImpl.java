package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Supplier;
import no.satyam.spring.northwind.repository.SupplierRepository;
import no.satyam.spring.northwind.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;
    
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        repository.delete(supplier);
    }

    @Override
    public List<Supplier> findByCompanyName(String companyName) {
        return repository.findByCompanyName(companyName);
    }

    @Override
    public List<Supplier> findByContactName(String contactName) {
         return repository.findByContactName(contactName);
    }

    @Override
    public List<Supplier> findByContactTitle(String contactTitle) {
         return repository.findByContactTitle(contactTitle);
    }

    @Override
    public List<Supplier> findByCountry(String country) {
         return repository.findByCountry(country);
    }
    
}
