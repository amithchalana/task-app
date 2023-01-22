package lk.ijse.dep9.app;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement    //use to enable transaction and connection management
public class WebRootConfig {

    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
        jndi.setJndiName("java:com/env/jdbc/task-app");
        jndi.setExpectedType(DataSource.class);
        return jndi;
    }





//    @Bean(destroyMethod = "close")     // when bean destroy connection close method execute
//    @Scope("request")
//    public Connection connection(DataSource dataSource) throws  SQLException {
//        return dataSource.getConnection();
//
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }


}
