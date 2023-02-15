package lk.EasyCarRental;

import lk.EasyCarRental.config.WebAppConfig;
import lk.EasyCarRental.config.WebRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected Class<?>[] getRootConfigClasses() {
        //root tynm root config class ek denne ona
        return new Class[]{WebRootConfig.class};
        }

@Override
protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
        }

@Override
protected String[] getServletMappings() {
        //default mapping. dispatcher servlet initialize krla tynwa
        return new String[]{"/"};
        }
}