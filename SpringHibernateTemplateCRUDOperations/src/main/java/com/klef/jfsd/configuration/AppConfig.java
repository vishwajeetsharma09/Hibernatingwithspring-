package com.klef.jfsd.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.klef.jfsd.service.StudentDAO;
import com.klef.jfsd.service.StudentDAOImpl;

@Configuration
@EnableTransactionManagement
public class AppConfig 
{
  @Bean
  public BasicDataSource dataSource() //connection properties
  {
    BasicDataSource dataSource = new BasicDataSource();
    
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/springhibernate?useSSL = false");
    dataSource.setUsername("root");
    dataSource.setPassword("piro@1234");
    
    return dataSource;
  }
  
  @Bean
  public Properties hibernateProperties() 
  {
    Properties hibernateProperties = new Properties();
    
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    
    return hibernateProperties;
  }
  
  @Bean
  public LocalSessionFactoryBean localSessionFactoryBean() 
  {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    
    localSessionFactoryBean.setDataSource(dataSource());
    localSessionFactoryBean.setHibernateProperties(hibernateProperties());
    localSessionFactoryBean.setPackagesToScan("com.klef.jfsd.model");
    
    return localSessionFactoryBean;
  }  
  
  @Bean
  public HibernateTransactionManager hibernateTransactionManager() 
  {
    
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    
    hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
  
    return hibernateTransactionManager;
  }
  @Bean
  public HibernateTemplate hibernateTemplate() 
  {
    HibernateTemplate hibernateTemplate = new HibernateTemplate();
    
    hibernateTemplate.setSessionFactory(localSessionFactoryBean().getObject());
  
    return hibernateTemplate;
  }
  
  @Bean
  public StudentDAO studentDao(){
    
    StudentDAOImpl dao = new StudentDAOImpl();
    
    dao.setHibernateTemplate(hibernateTemplate());
    return (StudentDAO) dao;
  }

}