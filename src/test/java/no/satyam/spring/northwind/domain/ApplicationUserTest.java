package no.satyam.spring.northwind.domain;

import no.satyam.spring.northwind.ApplicationConfigTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 *
 * @author srt
 */
public class ApplicationUserTest {

    @Test
    public void bootstrapAppFromJavaConfig() {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigTest.class);
        assertThat(context, is(notNullValue()));
        //assertThat(context.getBean(ApplicationUser.class), is(notNullValue()));
    }

}
