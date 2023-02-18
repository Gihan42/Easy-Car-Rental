package lk.EasyCarRental.config;



import lk.EasyCarRental.advicer.AppWideExceptionHandler;
import lk.EasyCarRental.controller.AdminController;
import lk.EasyCarRental.controller.CarController;
import lk.EasyCarRental.controller.CustomerController;
import lk.EasyCarRental.controller.DriverController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.EasyCarRental")
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/customer/**").addResourceLocations("/customer/");
    }

}
