package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Shipper;

/**
 *
 * @author srt
 */
public interface ShipperService {

    List<Shipper> findAllShippers();

    Shipper saveShipper(Shipper shipper);

    void deleteShipper(Shipper shipper);

    Shipper findByCompanyName(String companyName);
}
