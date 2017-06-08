package pe.com.bbva.visitame.config;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
	
		//servletContext.addFilter("CORSFilter", CORSFilter.class).addMappingForUrlPatterns(null, false, "/*");
		
		servletContext.addListener(SessionListener.class);
		
		servlet.setLoadOnStartup(1);

	}

}
