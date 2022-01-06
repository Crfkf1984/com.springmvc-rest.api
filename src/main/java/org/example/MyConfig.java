package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSources() {
        ComboPooledDataSource combo = new ComboPooledDataSource();
        try {
            combo.setDriverClass("com.mysql.cj.jdbc.Driver");
            combo.setJdbcUrl("jdbc:mysql://localhost:3306/springmvc?useSSL=false&amp;serverTimezone=UTC");
            combo.setUser("root");
            combo.setPassword("Crfkf1984!");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return combo;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean local = new LocalSessionFactoryBean();
        local.setDataSource(dataSources());
        local.setPackagesToScan("org.example.entity");
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        prop.setProperty("hibernate.show_sql","true");
        local.setHibernateProperties(prop);
        return local;
    }

    @Bean
    public HibernateTransactionManager transaction() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
