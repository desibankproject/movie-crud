package oppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filterMovie")
public class MovieFilterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String planguage=request.getParameter("language");	
			//Here we are creating an ArrayList
			ArrayList<Movie>  movies=new ArrayList<Movie>();
			///Here we have to write query to fetch data from database
			try {
						
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root","mysql@1234");
					   //No need to set any input
					   String query="";
					   PreparedStatement pstmt;
                       if("All".equals(planguage)){
                    	     query="select title,director,year,story,poster,language  from movie_tbl";
                    	     pstmt=conn.prepareStatement(query);
                       }else{
                    	    query="select title,director,year,story,poster,language  from movie_tbl where language=?";
                    	     pstmt=conn.prepareStatement(query);
                    	     pstmt.setString(1,planguage );
                       }
					   
					   //we should use executeQuery to fetch data
					  ResultSet rs= pstmt.executeQuery();
					  while(rs.next()){
						  String title=rs.getString(1);
						  String director=rs.getString(2);
						  int year=rs.getInt(3);
						  String story=rs.getString(4);
						  String poster=rs.getString(5);
						  String language=rs.getString(6);
						  Movie tmovie=new Movie(title,year+"",director,language,story,poster);
						  movies.add(tmovie);
					  }
					   
			}catch(Exception ex){
				//below statement will print the error in details
				ex.printStackTrace();
			}
			
			request.setAttribute("pdata", movies);
			request.getRequestDispatcher("movie.jsp").forward(request,response);
	
	}

}
