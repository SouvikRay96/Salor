package com.salor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the response type
		response.setContentType("text/html");
		
		//Creating Session Object to invalidate the session
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("pwd");
		session.invalidate();
		response.sendRedirect("exitpage"); //Sending the user to the exit page of the web application
	}

}
