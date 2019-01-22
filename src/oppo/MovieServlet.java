package oppo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movieServlet")
public class MovieServlet extends HttpServlet {

	//ArrayList is data structure which holds  other objects....it is present inside a package that is called java.util
	//Generics
	 //this is dynamic

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String title=request.getParameter("title");
			String year=request.getParameter("year");
			String director=request.getParameter("director");
			String language=request.getParameter("language");
			String story=request.getParameter("story");
			String poster=request.getParameter("poster");
			Movie smovie=new Movie(title,year+"",director,language,story,poster);
			MovieData.addMovie(smovie);
			//Here we are creating an object and storing data inside it....
			//in below movie object we have our all the data which is coming from html page
			 ArrayList<Movie>  movies=MovieData.loadMovieData();
			//After sometime we will write code to persist this data into the database
			//here we are adding movie object inside request object using name =pdata
			request.setAttribute("pdata", movies);
			request.getRequestDispatcher("movie.jsp").forward(request,response);
	}

}
