package lk.EasyCarRental.config;


import lk.EasyCarRental.repo.AdminRepo;
import lk.EasyCarRental.repo.CustomerRepo;
import lk.EasyCarRental.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement //<-- transaction manage wenawa auto
@EnableJpaRepositories(basePackageClasses = {CustomerRepo.class, AdminRepo.class, DriverRepo.class})//<-- mehema denne customerrepo interface eka controller eke access krann ona nisa
@PropertySource("classpath:application.properties")
public class JpaConfig {


    @Autowired
    private Environment env;

    //method name apita kemati kemati ewa dann ba me wdiytmai tyenn ona
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean factoryBean  =   new LocalContainerEntityManagerFactoryBean();
        /* factoryBean.setPackagesToScan(env.getRequiredProperty("pro.entity"));*/
        factoryBean.setPackagesToScan(env.getRequiredProperty("pro.entity"));//<-- entity pacake ek tyna location denwa
        factoryBean.setDataSource(ds);//<-- datasource dagannwa
        factoryBean.setJpaVendorAdapter(va);//<-hibernate dagannwa
        return factoryBean;
    }

    @Bean        //factoryBean eke paramiter eke varible ekjn ena error resouvle krgnna hdanne
    public DataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("pro.driver"));
        ds.setUrl(env.getRequiredProperty("pro.url"));//<-- db kiyl database netnm aluth ekk hdann kiyl dila tiyenne
        ds.setUsername(env.getRequiredProperty("pro.username"));
        ds.setPassword(env.getRequiredProperty("pro.password"));
        return ds;
    }

    @Bean  //factoryBean eke paramiter eke varible ekjn ena error resouvle krgnna hdanne
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter va=new HibernateJpaVendorAdapter();
        va.setDatabase(Database.MYSQL);//<-- database ek set krnw ahubernet ekka
        va.setGenerateDdl(true);//<-query create krnwa (diale definition language)
        va.setDatabasePlatform(env.getRequiredProperty("pro.dial"));//<-- 8 version ek
        va.setShowSql(true);//<-- dial kjrna query tika blagnna
        return va;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
