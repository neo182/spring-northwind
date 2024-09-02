package no.satyam.spring.northwind.util;

/**
 * The original source is from Dr. Heinz Kabbutz See
 * https://www.javaspecialists.eu/archive/Issue137.html for details
 *
 * @author satyam
 */
public class LoggerFactory {

	public static org.slf4j.Logger makeSlf4j() {
		Throwable throwable = new Throwable();
		StackTraceElement directCaller = throwable.getStackTrace()[1];
		return org.slf4j.LoggerFactory.getLogger(directCaller.getClassName());
	}

}
