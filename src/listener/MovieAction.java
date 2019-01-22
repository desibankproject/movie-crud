package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MovieAction implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//you want to send email to the admin 
		ServletContext servletContext=arg0.getServletContext(); //this method will give you an instance of ServletContext
		servletContext.setAttribute("message", "Hey! we are watching moview!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		servletContext.setAttribute("mname", "TKEK");
		
		System.out.println("#############################Hey My application is up and running#####################");
		System.out.println("#############################Hey My application is up and running#####################");
		System.out.println("#############################Hey My application is up and running#####################");
		System.out.println("#############################Hey My application is up and running#####################");
		System.out.println("#############################Hey My application is up and running#####################");
		System.out.println("#############################Hey My application is up and running#####################");
		
	}

}
