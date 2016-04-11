package no.satyam.spring.northwind.serviceImpl;

import java.util.List;
import no.satyam.spring.northwind.domain.AbstractIntegrationTest;
import no.satyam.spring.northwind.domain.ApplicationUser;
import no.satyam.spring.northwind.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author srt
 */
 

public class ApplicationUserServiceImpTest extends AbstractIntegrationTest{
    
    
    @Autowired
    private ApplicationUserService service;

    @Test
    public void testWiring() {
        assertNotNull(service);
    }
    
    @Test
    public void testGetAllUser(){
        List<ApplicationUser> users = service.getAllUsers();
        assertNotNull(users);
        System.out.println("userlist size is " + users.size());
        assertTrue(users.size() > 0);
    }
    
    
}
