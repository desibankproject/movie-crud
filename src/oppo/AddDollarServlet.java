package oppo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddDollarServlet
 */
@WebServlet("/addDollar")
public class AddDollarServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dollar=request.getParameter("dollar");
		//Create session object or scope if it is not there....
		HttpSession session=request.getSession();
		
		ArrayList<Integer> sbags=(ArrayList<Integer>)session.getAttribute("sbags");
		if(sbags==null){
				sbags=new ArrayList<Integer>();
		}
		sbags.add(Integer.parseInt(dollar));
		session.setAttribute("sbags",sbags);
		
		request.setAttribute("message", "Hey! "+dollar+" I have received!!!!!!!!!");
		request.getRequestDispatcher("add-dollar.jsp").forward(request,response);
	}

}
