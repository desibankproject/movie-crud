package filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ShowTimeFilter implements Filter {
	
	
	long startTime = 13*60*60*1000; //1 PM
	long endTime = 14*60*60*1000; //2 PM
	

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest prequest=(HttpServletRequest)request;
		String urlPattern=prequest.getServletPath();
		System.out.println("Page "+urlPattern +" is accessed at "+LocalDateTime.now());
		if("/movieServlet".equals(urlPattern)) {
		 	 Date date = new Date();
		      //This method returns the time in millis
		 	  LocalTime localTime=LocalTime.now();
		 	 long timeMilli=(localTime.getHour()+0)*60*60*1000+localTime.getMinute()*60*1000+localTime.getSecond()*1000;
		      System.out.println(startTime);
		      System.out.println(timeMilli);
		      System.out.println(endTime);
		      if(timeMilli>=startTime && timeMilli<=endTime) {
		    	//Go ahead to access your resource....
					chain.doFilter(request, response);	
		      }else{
		    	    //Send Redirect
		    	   HttpServletResponse presponse=(HttpServletResponse)response;
		    	   presponse.sendRedirect("block.jsp");
		      }
		}else{
			//Go ahead to access your resource....
			chain.doFilter(request, response);	
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
