package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Shipper;
import no.satyam.spring.northwind.repository.ShipperRepository;
import no.satyam.spring.northwind.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class ShipperServiceImpl implements ShipperService {

    @Autowired
    private ShipperRepository repository;

    @Override
    public Shipper findByCompanyName(String companyName) {
        return repository.findByCompanyName(companyName);
    }

    @Override
    public List<Shipper> findAllShippers() {
        return repository.findAll();
    }

    @Override
    public Shipper saveShipper(Shipper shipper) {
        return repository.save(shipper);
    }

    @Override
    public void deleteShipper(Shipper shipper) {
        repository.delete(shipper);
    }

}
