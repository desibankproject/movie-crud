package oppo;

import java.io.IOException;
import java.sql.*;

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
			//Write Java code to insert data into the database
			//Step-1 >>>Write SQL query
			 String query="insert into movie_tbl values(?,?,?,?,?,?)";
			 try {
				   //Step-1 -- loading the driver
				   Class.forName("com.mysql.jdbc.Driver");
				   	//Making connection
				   //connection url = jdbc:mysql://localhost:3306/movies_db 
				   //dbusername = root
				   //dbpassword = mysql@1234
				   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root","mysql@1234");
				   //pstmt holds compiled query
				   PreparedStatement pstmt=conn.prepareStatement(query);
				 
				   //setting data inside the query
				   pstmt.setString(1, title);
				   pstmt.setString(2, director);
				   pstmt.setInt(3,2018);
				   pstmt.setString(4, story);
				   pstmt.setString(5, poster);
				   pstmt.setString(6, language);
				   
				   //Fire the query
				   pstmt.executeUpdate();
				 
			 }catch(Exception supriya){
				 supriya.printStackTrace();
			 }
			//Here we are creating an object and storing data inside it....
			//in below movie object we have our all the data which is coming from html page
			Movie movie=new Movie(title,year,director,language,story,poster);
			MovieData.movies.add(movie);
			//After sometime we will write code to persist this data into the database
			//here we are adding movie object inside request object using name =pdata
			request.setAttribute("pdata", MovieData.movies);
			
			request.getRequestDispatcher("movie.jsp").forward(request,response);
	}

}
