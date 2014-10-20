package sk.city.vegetarian;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"sk.city.vegetarian.domain.menu"})
public class MyMvcConfiguration extends RepositoryRestMvcConfiguration {
	public MyMvcConfiguration() {
		super();
	}
}
