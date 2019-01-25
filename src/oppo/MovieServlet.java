package oppo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import sun.misc.IOUtils;


//CRT + SHIFT+O
@WebServlet("/movieServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class MovieServlet extends HttpServlet {

	//ArrayList is data structure which holds  other objects....it is present inside a package that is called java.util
	//Generics
	 //this is dynamic

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // obtains the upload file part in this multipart request
		    Part filePart = request.getPart("photo");
		    byte[] image=null;
		    if(filePart!=null){
		    	InputStream inputStream = filePart.getInputStream();
		    	 image = IOUtils.readFully(inputStream, -1, false);
		    }
	
			String title=request.getParameter("title");
			String year=request.getParameter("year");
			String director=request.getParameter("director");
			String language=request.getParameter("language");
			String story=request.getParameter("story");
			String poster=request.getParameter("poster");
			Movie smovie=new Movie(title,year+"",director,language,story,poster);
			//Here we are setting image inside Movie object
			smovie.setPhoto(image);
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
