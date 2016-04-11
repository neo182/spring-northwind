package no.satyam.spring.northwind;

import com.zaxxer.hikari.HikariConfig;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author srt
 */
public class DataSourceProvider {

    public static DataSource getMySqlDataSource() {
        DriverManagerDataSource toReturn = new DriverManagerDataSource("jdbc:mysql://localhost:3306/northwindspringdb",
                "root", "");
        toReturn.setDriverClassName("com.mysql.jdbc.Driver");
        return toReturn;
    }

    public static DataSource getDerbyDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/h:/temp/northwindspringdb");
        return dataSource;
    }

    public static DataSource getMySqlDataSourceWithHikariConfig() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/northwindspringdb;ifexists=true;shutdown=true;");
        return dataSourceConfig.getDataSource();
    }

    public static DataSource getMySqlDataSourceWithBasicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwindspringdb");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
