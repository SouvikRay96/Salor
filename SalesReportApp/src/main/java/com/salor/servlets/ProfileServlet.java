package com.salor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.salor.factory.SalorServiceFactory;
import com.salor.service.SalorServiceInterface;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Response Type
		response.setContentType("text/html");
		
		//Creating the Session Object to get the Attribute UserId
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		//Creating SalorService Class Object
		SalorServiceInterface salorService = SalorServiceFactory.getSalorServiceObject();
		
		//Getting the Profile Informations in the String Array
		String[] profileInfo = salorService.profileInfoService(userid);
		
		//System.out.println(profileInfo);
		
		session.setAttribute("userid", profileInfo[0]);
		session.setAttribute("orgname", profileInfo[1]);
		session.setAttribute("emailid", profileInfo[2]);
		session.setAttribute("address", profileInfo[3]);
		session.setAttribute("orgsize", profileInfo[4]);
		session.setAttribute("ownername", profileInfo[5]);
		
		response.sendRedirect("profile");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
