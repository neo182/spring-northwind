package no.satyam.spring.northwind.service;

import no.satyam.spring.northwind.domain.SalesOrderDetails;

/**
 *
 * @author srt
 */
public interface SalesOrderDetailsService {

    SalesOrderDetails saveSalesOrderDetail(SalesOrderDetails salesOrderDetails);

    void deleteSalesOrderDetails(SalesOrderDetails salesOrderDetails);

}
