package com.nikesh.storage.app.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DatasourceConfig {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "connection.driverClass";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "connection.pass";
    private static final String PROPERTY_NAME_DATABASE_URL = "connection.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "connection.user";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment env;


    @Bean
    public DataSource getDatasource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(env.getProperty(PROPERTY_NAME_DATABASE_URL));
        ds.setUsername(env.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
        ds.setPassword(env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        ds.setDriverClassName(env.getProperty(PROPERTY_NAME_DATABASE_DRIVER));

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDatasource());

        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
