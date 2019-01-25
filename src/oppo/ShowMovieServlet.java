package oppo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMovieServlet
 */
@WebServlet("/showMovies")
public class ShowMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Here we are creating an object and storing data inside it....
		//in below movie object we have our all the data which is coming from html page
		 ArrayList<Movie>  movies=MovieData.loadMovieData();
		//After sometime we will write code to persist this data into the database
		//here we are adding movie object inside request object using name =pdata
		request.setAttribute("pdata", movies);
		request.getRequestDispatcher("movie.jsp").forward(request,response);
	}


}
