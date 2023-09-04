package com.salor.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.salor.factory.ConnectionFactory;

/**
 * Servlet implementation class SalorStartServlet
 */
@WebServlet(value = "/SalorStartServlet",loadOnStartup = 1)
public class SalorStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con = null;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//Creating Connection Object
		try {
			con = ConnectionFactory.getConnectionObject();
			if(con != null) {
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Connection Not Established");
			}
		} catch (Exception e) {
			throw new ServletException("Error in init() of "+getClass().getName(),e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type of the page
		response.setContentType("text/html");
		
		//Redirecting to the HomePage
		response.sendRedirect("homepage");
		
	}
	

	

}
