package sk.city.vegetarian;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"sk.city.vegetarian"})
@EnableJpaRepositories(basePackages = "sk.city.vegetarian.domain")
@EnableTransactionManagement
public class LocalApplicationConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("sk.city.vegetarian.domain");
		factory.setDataSource(dataSource());
		return factory;
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
		
		
		dataSource.setUrl("jdbc:postgresql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":"
				+ System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/"+System.getenv("OPENSHIFT_APP_NAME"));
		dataSource.setUsername(System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"));
		dataSource.setPassword(System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));		
		
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(1800000L);
		dataSource.setNumTestsPerEvictionRun(3);
		dataSource.setMinEvictableIdleTimeMillis(1800000L);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}
	
	@Bean
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}