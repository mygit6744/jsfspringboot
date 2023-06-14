package com.yugandhar.app;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.ServletContextAware;

import com.icesoft.faces.webapp.CompatResourceServlet;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yugandhar"})
@EnableJpaRepositories("com.yugandhar.jps.repository") 
@EntityScan("com.yugandhar.entity")  
public class SpringJsfApplication extends SpringBootServletInitializer implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringJsfApplication.class, args);
    }
    @Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL", "true");
		servletContext.setInitParameter("javax.faces.WEBAPP_RESOURCES_DIRECTORY", "/WEB-INF/resources");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
		servletContext.setInitParameter("com.icesoft.faces.gmapKey", "ABQIAAAADlu0ZiSTam64EKaCQr9eTRTOTuQNzJNXRlYRLknj4cQ89tFfpxTEqxQnVWL4k55OPICgF5_SOZE06A");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.addListener(new org.springframework.web.context.ContextLoaderListener());
	}
    @Bean
    public ServletRegistrationBean<?> servletRegistrationBean() {
        FacesServlet servlet = new javax.faces.webapp.FacesServlet();
        return new ServletRegistrationBean<>(servlet, "/faces/*");
    }
    @Bean
    public ServletRegistrationBean<?> servletRegistrationBean2() {
        CompatResourceServlet servlet = new com.icesoft.faces.webapp.CompatResourceServlet();
        return new ServletRegistrationBean<>(servlet, "/xmlhttp/*");
    }
    @Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}
    

}
