package ng.nectar.configuration;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	/*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(Integer.valueOf(System.getenv("PORT")));  
            container.setSessionTimeout(360);
        });
    }*/
}