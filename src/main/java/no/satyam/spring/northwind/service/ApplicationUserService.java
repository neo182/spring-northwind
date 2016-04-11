package no.satyam.spring.northwind.service;

import java.util.List;
import no.satyam.spring.northwind.domain.ApplicationUser;

/**
 *
 * @author srt
 */
public interface ApplicationUserService {

    public List<ApplicationUser> getAllUsers();

    public ApplicationUser saveUser(ApplicationUser user);

    public void deleteUser(ApplicationUser user);

    public ApplicationUser findByUserName(String userName);

}
