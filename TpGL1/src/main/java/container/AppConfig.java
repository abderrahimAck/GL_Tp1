package container;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan("ack.projet1")
public class AppConfig
{
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ensa_TpGL1" ;
	private static final String USERNAME = "root" ;
	private static final String PASSWORD = "" ;
	
	private static final Object HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect" ;
	private static final Object HIBERNATE_HBM2DDL_AUTO = "update" ;
	private static final Object HIBERNATE_SHOW_SQL = "true" ;


	
	// Data Source
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
	    dataSource.setUrl(URL);
	    dataSource.setUsername(USERNAME);
	    dataSource.setPassword(PASSWORD);
		return dataSource ;
	}
	
	// Session Factory
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean() ;
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		//sessionFactory.setAnnotatedClasses(new Class[] {Client.class,Commande.class});
		sessionFactory.setPackagesToScan("ack.projet1.entities");
		
		return sessionFactory ;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties() ;
		properties.put("hibernate.dialect",HIBERNATE_DIALECT) ;
		properties.put("hibernate.hbm2ddl.auto",HIBERNATE_HBM2DDL_AUTO);
	    properties.put("hibernate.show_sql",HIBERNATE_SHOW_SQL);
		
		return properties ;
	}
	

}
