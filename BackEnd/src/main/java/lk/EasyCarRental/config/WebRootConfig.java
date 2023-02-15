package lk.EasyCarRental.config;



import lk.EasyCarRental.service.impl.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaConfig.class)
@ComponentScan(basePackageClasses = CustomerServiceImpl.class)
public class WebRootConfig {
    @Bean
    public ModelMapper moddlMapper(){
        return new ModelMapper();
    }
}