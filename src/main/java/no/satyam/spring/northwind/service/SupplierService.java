package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Supplier;

/**
 *
 * @author srt
 */
public interface SupplierService {

    public Supplier saveSupplier(Supplier supplier);

    public List<Supplier> getAllSuppliers();

    public void deleteSupplier(Supplier supplier);

    public List<Supplier> findByCompanyName(String companyName);

    public List<Supplier> findByContactName(String contactName);

    public List<Supplier> findByContactTitle(String contactTitle);

    public List<Supplier> findByCountry(String country);
}
