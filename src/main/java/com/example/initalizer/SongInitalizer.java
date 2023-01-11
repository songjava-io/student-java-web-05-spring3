package com.example.initalizer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.configuration.ApplicationConfiguration;
import com.example.configuration.DispatcherConfiguration;

public class SongInitalizer
	implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext
			applicationContext = new AnnotationConfigWebApplicationContext();
		
		applicationContext.register(ApplicationConfiguration.class);
		
		// web.xml listener
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		
		
		AnnotationConfigWebApplicationContext
		dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherConfiguration.class);
		
		// web.xml servlet 등록
		
		Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", 
				new DispatcherServlet(dispatcherContext));
		
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");
		
		// filter 등록
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("characterFilter", 
				CharacterEncodingFilter.class);
		
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceEncoding", "true");
		filter.addMappingForUrlPatterns(null, false, "/");
		
	}

	
}
