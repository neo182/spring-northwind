package no.satyam.spring.northwind.service;

import java.sql.Date;
import java.util.List;
import no.satyam.spring.northwind.domain.Customer;
import no.satyam.spring.northwind.domain.Employee;
import no.satyam.spring.northwind.domain.SalesOrder;
import no.satyam.spring.northwind.domain.Shipper;

/**
 *
 * @author srt
 */
public interface SalesOrderService {
    
    SalesOrder saveSalesOrder(SalesOrder salesOrder);
    
    void deleteSalesOrder(SalesOrder salesOrder);
    
    List<SalesOrder> findByCustomer(Customer customer);

    List<SalesOrder> findByEmployee(Employee employee);

    List<SalesOrder> findByShipper(Shipper shipper);

    List<SalesOrder> findByOrderDateBetween(Date startOrderDate, Date endOrderDate);
}
