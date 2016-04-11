package no.satyam.spring.northwind.serviceImpl;

import java.sql.Date;
import java.util.List;
import no.satyam.spring.northwind.domain.Customer;
import no.satyam.spring.northwind.domain.Employee;
import no.satyam.spring.northwind.domain.SalesOrder;
import no.satyam.spring.northwind.domain.Shipper;
import no.satyam.spring.northwind.repository.SalesOrderRepository;
import no.satyam.spring.northwind.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderRepository repository;

    @Override
    public SalesOrder saveSalesOrder(SalesOrder salesOrder) {
        return repository.save(salesOrder);
    }

    @Override
    public void deleteSalesOrder(SalesOrder salesOrder) {
        repository.delete(salesOrder);
    }

    @Override
    public List<SalesOrder> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public List<SalesOrder> findByEmployee(Employee employee) {
        return repository.findByEmployee(employee);
    }

    @Override
    public List<SalesOrder> findByShipper(Shipper shipper) {
        return repository.findByShipper(shipper);
    }

    @Override
    public List<SalesOrder> findByOrderDateBetween(Date startOrderDate, Date endOrderDate) {
        return repository.findByOrderDateBetween(startOrderDate, endOrderDate);
    }

}
