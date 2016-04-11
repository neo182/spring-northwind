package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.Employee;
import no.satyam.spring.northwind.repository.EmployeeRepository;
import no.satyam.spring.northwind.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srt
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeRepository repository;
    
    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<Employee> findByTitle(String title) {
        return repository.findByTitle(title);
    }
    
}
