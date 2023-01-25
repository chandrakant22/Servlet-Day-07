import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/serv1")
public class MyServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");

		
		Cookie c=new Cookie("uname", name);
		response.addCookie(c);
		
		out.print("<h1>Welcmome to Servlet 1 : "+name+"</h1>");
		
		out.print("<a href='serv2'>Go Servlet 2</a>"); 
		out.print("<a href='logout'>Logout</a>"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
