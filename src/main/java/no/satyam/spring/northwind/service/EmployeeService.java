package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.Employee;

/**
 *
 * @author srt
 */
public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public List<Employee> findAllEmployees();

    public List<Employee> findByFirstName(String firstName);

    public List<Employee> findByLastName(String lastName);

    public List<Employee> findByCountry(String country);

    public List<Employee> findByTitle(String title);

}
