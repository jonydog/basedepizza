package com.jpinto.basedepizza.configs;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:application.properties")
public class ServiceConfigurations {

	
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	@Primary
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .build();
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jpaVendorAdapter;
	}

/*	@Bean
	@Autowired
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		logger.debug("Configuring EntityManager");
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
		lcemfb.setPersistenceUnitName("persistenceUnit");
		lcemfb.setDataSource(dataSource);
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setSharedCacheMode(SharedCacheMode.NONE);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.generate_statistics", false);
		lcemfb.setJpaProperties(jpaProperties);
		lcemfb.setPackagesToScan("pt.agap2.academy.horus.webportal.model","pt.agap2.academy.horus.persistence.common.model","pt.agap2.academy.socialactions.domain");
		lcemfb.afterPropertiesSet();
		return lcemfb.getObject();
	}*/

	
}
