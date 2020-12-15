package com.tuanphamjava.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.tuanphamjava.repository"}) // de cau hinh su dung duoc NewRepository
@EnableTransactionManagement // quan ly Transaction
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() { // open connection
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());// cau hinh mysql
		em.setPersistenceUnitName("persistence-data"); //persistence-data la chat xuc tac giua entity va mysql
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties()); //
		return em;
	}


	// quan ly transaction roback, commit
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


	// get connection
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcbasicfree");
		dataSource.setUsername("root");
		dataSource.setPassword("Tuanpham3676");
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		//properties.setProperty("hibernate.hbm2ddl.auto", "update");
		//properties.setProperty("hibernate.hbm2ddl.auto", "create"); // neu database table chua co thi dung lenh nay
		properties.setProperty("hibernate.hbm2ddl.auto", "none"); // neu database da on dinh thi dung lenh nay
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
