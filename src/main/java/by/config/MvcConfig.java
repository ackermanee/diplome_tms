package by.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**", "/styles/**", "/static/**", "/resources/**", "/js/**")
                .addResourceLocations("classpath:/images/", "classpath:/styles/", "classpath:/static/", "classpath:/resources/", "classpath:/js/");
    }
}
