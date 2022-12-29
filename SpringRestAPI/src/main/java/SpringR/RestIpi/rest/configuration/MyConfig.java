package SpringR.RestIpi.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "SpringR.RestIpi.rest")
@EnableWebMvc
public class MyConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("");//вписывается база данных
        dataSource.setJdbcUrl("");
        dataSource.setUser("");
        dataSource.setPassword("");
        return dataSource;
    }
    //@Bean
//    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
//        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("SpringR.RestIpi.rest.entity");
//
//        Properties properties = new Properties();
//        //properties.setProperty("hibernate.dialect.MySQLDialect")
//    }
//    @Bean
//    public HibernateTransactioManager hibernateTransactioManager() {
//        HibernateTransactioManager hibernateTransactioManager = new HibernateTransactioManager();
//        hibernateTransactioManager.setSessionFactory(sessionFactory().getObject());
//        return hibernateTransactioManager;
//    }
}
