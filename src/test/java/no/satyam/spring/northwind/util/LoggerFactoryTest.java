package no.satyam.spring.northwind.util;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author srt
 */
public class LoggerFactoryTest {



    @Test(groups = {"unit"})
    public void testMakeSlf4jWorksProperly() {
        org.slf4j.Logger log = LoggerFactory.makeSlf4j();
        assertNotNull(log);
    }

}
