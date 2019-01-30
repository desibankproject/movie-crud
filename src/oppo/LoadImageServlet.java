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
 * Servlet implementation class LoadImageServlet
 */
@WebServlet("/loadImage")
public class LoadImageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		try {
				  String query="select photo from movie_tbl where mid=?";
				   Class.forName("com.mysql.jdbc.Driver");
				   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies_db","root","mysql@1234");
				   //No need to set any input
				   PreparedStatement pstmt=conn.prepareStatement(query);
				   pstmt.setInt(1, Integer.parseInt(mid));
				   //we should use executeQuery to fetch data
				  ResultSet rs= pstmt.executeQuery();
				  byte [] bytes=null;
				  if(rs.next()){
					  Blob blob = rs.getBlob("photo");
				      bytes = blob.getBytes(1l, (int)blob.length());
				  }
				  //write  this byte[] into response so that I can reach to the browser
				  //Here We have to write very very very special code
				  response.setContentType("image/png");
				  ServletOutputStream outputStream=response.getOutputStream();
				  outputStream.write(bytes);
				  if(outputStream!=null) {
					  outputStream.flush();
					  outputStream.close();  
				  }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
