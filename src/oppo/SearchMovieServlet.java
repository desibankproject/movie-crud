package oppo;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet("/searchMovie")
public class SearchMovieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stitle=request.getParameter("title");
		//Here we are creating an ArrayList
		ArrayList<Movie>  movies=new ArrayList<Movie>();
		///Here we have to write query to fetch data from database
		try {
					String query="select title,director,year,story,poster,language,mid  from movie_tbl where title=?";
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root","mysql@1234");
				   //No need to set any input
				   PreparedStatement pstmt=conn.prepareStatement(query);
				   pstmt.setString(1, stitle);
				   //we should use executeQuery to fetch data
				  ResultSet rs= pstmt.executeQuery();
				  while(rs.next()){
					  String title=rs.getString(1);
					  String director=rs.getString(2);
					  int year=rs.getInt(3);
					  String story=rs.getString(4);
					  String poster=rs.getString(5);
					  String language=rs.getString(6);
					  int mid=rs.getInt(7);
					  Movie tmovie=new Movie(title,year+"",director,language,story,poster);
					  tmovie.setMid(mid);
					  movies.add(tmovie);
				  }
				   
		}catch(Exception ex){
			//below statement will print the error in details
			ex.printStackTrace();
		}
		request.setAttribute("searchResults", movies);
		request.getRequestDispatcher("search-movies.jsp").forward(request,response);
		
	}


}
