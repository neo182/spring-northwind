package no.satyam.spring.northwind.bootstrap;

import java.util.List;
import no.satyam.spring.northwind.domain.ApplicationUser;
import no.satyam.spring.northwind.service.ApplicationUserService;
import no.satyam.spring.northwind.util.ContextManager;
/**
 *
 * @author srt
 */

public class AppUserBeanTest {
    public static void main(String[] args) {
        ApplicationUserService service = ContextManager.getBean(ApplicationUserService.class);
        
        List<ApplicationUser> list = service.getAllUsers();
         if(list == null || list.isEmpty()){
            System.out.println("List is null");
        }
        System.out.println("The size of list is " + list.size());
    }
}
