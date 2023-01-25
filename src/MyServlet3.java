

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/serv3")
public class MyServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie c[]=request.getCookies();


		if(c==null)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			
			out.print("<p style='color:red'>Please Login first</p>"); 
		}
		else
		{
		out.print("<h1>Welcmome to Servlet 3 : "+c[0].getValue()+"</h1>");
		out.print("<a href='logout'>Logout</a>"); 
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}

