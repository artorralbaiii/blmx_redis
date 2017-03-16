package net.tutorial.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tutorial.utilities.RedisService;

@WebServlet({ "home", "" })
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RedisService redis = new RedisService();
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Redis DEMO</h1>");

		redis.printValues(out);
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	

}
