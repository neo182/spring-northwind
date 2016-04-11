package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.ApplicationUser;
import no.satyam.spring.northwind.repository.ApplicationUserRepository;
import no.satyam.spring.northwind.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srt
 */
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository repository;

    @Override
    public List<ApplicationUser> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(ApplicationUser user) {
        repository.delete(user);
    }

    @Override
    public ApplicationUser findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
