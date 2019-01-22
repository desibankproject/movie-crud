package oppo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {

	//if we call a servlet by hyperlink then we can use only GET method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
	   
		//Below method will delete data from database as per title coming from GUI
		MovieData.deleteMovieByTitle(title);
		//Here write logic to delete data from ArrayList by title
		ArrayList<Movie> movies=MovieData.loadMovieData();
		/*for(Movie tea:movies) {
			  if(tea.getTitle().equals(title)){
				  movies.remove(tea);
				  break;
			  }
		}*/
		//After sometime we will write code to persist this data into the database
		//here we are adding movie object inside request object using name =pdata
		request.setAttribute("pdata", movies);
		request.getRequestDispatcher("movie.jsp").forward(request,response);
	}

}
