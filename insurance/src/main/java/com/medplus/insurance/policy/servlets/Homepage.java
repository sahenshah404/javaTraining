package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.insurance.policy.service.User_RoleService;
import com.medplus.insurance.policy.service.User_RoleServiceImpl;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User_RoleService user_RoleService = new User_RoleServiceImpl();
		
		if(session.getAttribute("role") == null) {
			response.sendRedirect("Login");
		}else {
			
			if(session.getAttribute("role").equals("insured")) {
				String accountStatus = user_RoleService.checkIfAccountCreated((String) session.getAttribute("username"));
				session.setAttribute("account", accountStatus);
			}
			request.getRequestDispatcher("Homepage.jsp").forward(request, response);
		}
	}

}
