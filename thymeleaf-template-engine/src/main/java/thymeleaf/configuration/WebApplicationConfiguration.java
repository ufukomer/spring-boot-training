package thymeleaf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import thymeleaf.formatter.DateFormatter;

/**
 * Created by Ufuk on 15-10-15.
 */
@Configuration
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private DateFormatter dateFormatter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter);
    }
}
