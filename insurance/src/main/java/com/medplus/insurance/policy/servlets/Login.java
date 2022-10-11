package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.medplus.insurance.policy.service.User_RoleService;
import com.medplus.insurance.policy.service.User_RoleServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("role") == null) {
			request.getRequestDispatcher("Login.jsp").include(request, response);
		} else {
//			request.getRequestDispatcher("Homepage").forward(request, response);
			response.sendRedirect("Homepage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.length() < 1 || password.length() < 1) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<p class = 'alert'>Please Enter your Credential</p>");
			doGet(request, response);
		} else {
			User_RoleService user_role = new User_RoleServiceImpl();
			String role = user_role.Login(username,password);
			if (role != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("role", role);
				
				
				response.sendRedirect("Homepage");
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<p class = 'alert'>Invalid Credentials</p>");
				doGet(request, response);
			}
		}

	}

}
