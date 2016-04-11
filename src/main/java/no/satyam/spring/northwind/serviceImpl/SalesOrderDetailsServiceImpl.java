package no.satyam.spring.northwind.serviceImpl;

import no.satyam.spring.northwind.domain.SalesOrderDetails;
import no.satyam.spring.northwind.repository.SalesOrderDetailsRepository;
import no.satyam.spring.northwind.service.SalesOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class SalesOrderDetailsServiceImpl implements SalesOrderDetailsService{
    @Autowired
    private SalesOrderDetailsRepository repository;
    
    @Override
    public SalesOrderDetails saveSalesOrderDetail(SalesOrderDetails salesOrderDetails) {
        return repository.save(salesOrderDetails);
    }

    @Override
    public void deleteSalesOrderDetails(SalesOrderDetails salesOrderDetails) {
        repository.delete(salesOrderDetails);
    }
    
}
