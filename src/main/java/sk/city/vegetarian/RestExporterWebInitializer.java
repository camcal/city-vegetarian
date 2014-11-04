package sk.city.vegetarian;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


@Configuration
public class RestExporterWebInitializer implements WebApplicationInitializer {
	
	private static Logger LOG = LoggerFactory.getLogger(RestExporterWebInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(LocalApplicationConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootCtx));

		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(MyMvcConfiguration.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
		ServletRegistration.Dynamic reg = servletContext.addServlet("rest-exporter", dispatcherServlet);
		reg.setLoadOnStartup(1);
		reg.addMapping("/rest/*");
	}

}
