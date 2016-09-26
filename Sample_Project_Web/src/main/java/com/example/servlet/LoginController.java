package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.service.MessageService;
import org.apache.log4j.Logger;
/**
 * Servlet implementation class Session
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
LOGGER.info("in doPost method");
		PrintWriter out = response.getWriter();
		String un = request.getParameter("uname");
		String pwd = request.getParameter("pass");
LOGGER.info("username: "+un);
LOGGER.info("password: "+pwd);
MessageService msg=new MessageService();
		if (un.equals("admin")) {
			out.print("Welcome, " + un);
out.print("Msg from Server: , " + msg.getMessage());
			HttpSession session = request.getSession(true); // reuse existing
															// session if exist
															// or create one
			session.setAttribute("user", un);
			session.setMaxInactiveInterval(30); // 30 seconds
			response.sendRedirect("home.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		} // TODO Auto-generated method stub
	}
}