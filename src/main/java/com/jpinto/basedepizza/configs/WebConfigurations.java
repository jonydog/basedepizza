package com.jpinto.basedepizza.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
public class WebConfigurations {

	
	@Bean
	public  TemplateResolver templateResolver() {
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setPrefix("pages/");
	    resolver.setSuffix(".html");
	    resolver.setCacheable(false);
	    return resolver;
	}
	
}
