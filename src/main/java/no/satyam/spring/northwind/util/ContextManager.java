package no.satyam.spring.northwind.util;

import no.satyam.spring.northwind.ApplicationConfigProd;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author srt
 */
public class ContextManager {

    private static ApplicationContext context;

    static {
        context = new AnnotationConfigApplicationContext(ApplicationConfigProd.class);
    }

    public static <T extends Object> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }

}
