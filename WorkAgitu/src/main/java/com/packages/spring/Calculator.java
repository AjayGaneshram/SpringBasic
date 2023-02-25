package com.packages.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//Approach -1
//with the help of WebApplicationInitializer
public class Calculator  {
  //implements WebApplicationInitializer
    public void onStartup(ServletContext servletContext)
        throws ServletException
    {
         //xml based configuration 
		/*
		 * XmlWebApplicationContext webApplicationContext = new
		 * XmlWebApplicationContext(); webApplicationContext.setConfigLocation(
		 * "classpath:application-config.xml");
		 */
    	
    	AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext(); 
    	webApplicationContext.register(ConfigurationClassu.class);
    	
    	
        // Creating a dispatcher servlet object
        DispatcherServlet dispatcherServlet
            = new DispatcherServlet( webApplicationContext);
  
        // Registering Dispatcher Servlet with Servlet
        // Context
        ServletRegistration
            .Dynamic myCustomDispatcherServlet
            = servletContext.addServlet(
                "myDispatcherServlet", dispatcherServlet);
        myCustomDispatcherServlet.setLoadOnStartup(1);
        
        // Adding mapping url
        myCustomDispatcherServlet.addMapping("/gfg.com/*");
    }
}
