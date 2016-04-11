package no.satyam.spring.northwind.bootstrap;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import no.satyam.spring.northwind.InfrastructureConfigProd;
import no.satyam.spring.northwind.domain.ApplicationUser;
import no.satyam.spring.northwind.service.ApplicationUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 *
 * @author srt
 */
public class BootstrapTest {

    public static void main(String[] args) throws SQLException {
        //insertData();
        sjekkData();
    }

    public static void insertData() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(InfrastructureConfigProd.class);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("data.sql"));

        Connection connection = null;
        DataSource dataSource = context.getBean("dataSource", DataSource.class);

        try {
            connection = dataSource.getConnection();
            populator.populate(connection);
            //populator.execute(dataSource);
        } finally {
            if (connection != null) {
                DataSourceUtils.releaseConnection(connection, dataSource);
            }
        }
    }

    public static void sjekkData() {
//        ApplicationUserService service = new ApplicationUserBean();
//        List<ApplicationUser> list = bean.getUsers();
//        if (list == null || list.isEmpty()) {
//            System.out.println("List is null");
//            return;
//        }
//        System.out.println("The size of list is " + list.size());

    }
}
