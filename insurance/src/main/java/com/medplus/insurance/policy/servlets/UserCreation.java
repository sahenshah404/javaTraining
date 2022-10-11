package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.insurance.policy.service.User_RoleService;
import com.medplus.insurance.policy.service.User_RoleServiceImpl;

/**
 * Servlet implementation class ProfileCreation
 */
@WebServlet("/UserCreation")
public class UserCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("UserCreation.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(username.length()<1 || password.length()<1 || role.length()<1) {
			out.print("<p class = 'alert'>Please enter your Credentials</p>");
			doGet(request, response);
		}else if (password.length()<4) {
			out.print("<p class = 'warning'>Password length should atleast be 5 characters</p>");
			doGet(request, response);
		}
		else {
			User_RoleService user_roleService = new User_RoleServiceImpl();
			String output = user_roleService.createUser(username,password,role);

			if(output.equals("user created"))
				out.print("<p class = 'success'> " + output +" </p>");
			else
				out.print("<p class = 'alert'>" + output +"</p>");
				
			doGet(request, response);
		}
	}

}
