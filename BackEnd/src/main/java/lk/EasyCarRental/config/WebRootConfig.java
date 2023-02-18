package lk.EasyCarRental.config;



import lk.EasyCarRental.service.impl.AdminServiceImpl;
import lk.EasyCarRental.service.impl.CarServiceImpl;
import lk.EasyCarRental.service.impl.CustomerServiceImpl;
import lk.EasyCarRental.service.impl.DriverServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaConfig.class)
@ComponentScan(basePackageClasses = {CustomerServiceImpl.class, AdminServiceImpl.class, DriverServiceImpl.class, CarServiceImpl.class})
public class WebRootConfig {
    @Bean
    public ModelMapper moddlMapper(){
        return new ModelMapper();
    }
}
